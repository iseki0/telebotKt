import api.ResultType
import api.type.Update
import com.fasterxml.jackson.databind.ObjectMapper
import io.vertx.core.AsyncResult
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient


const val TELEGRAM_BASE_URL = "https://api.telegram.org/bot"

class BotImpl(
    override val botOption: BotOption,
    override val vertx: Vertx
) : ApiContext, Bot {
    override var updateHandler: (update: Update) -> Unit = {}
    val context = vertx.orCreateContext!!
    val webClient = WebClient.create(vertx, botOption.webClientOptions)!!
    val urlGenerator = botOption.botServerInfo.urlGenerator
    override val mapper: ObjectMapper by lazy {
        getObjectMapper()
    }


    override fun <T : ResultType> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T> = Future.future { promise ->
        context.runOnContext {
            try {
                doSendMultipartForm(command, args, resultType, promise)
            } catch (e: Exception) {
                promise.tryFail(e)
            }
        }
    }

    private fun <T : ResultType> doSendMultipartForm(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>,
        promise: Promise<T>
    ) {
        val form = fillRequestForm(args)
        val timeout = defaultTimeout(command, args)
        webClient.postAbs(urlGenerator(botOption.botKey, command)).timeout(timeout).sendMultipartForm(form) {
            try {
                promise.tryComplete(parseResponse(it, resultType))
            } catch (e: Exception) {
                promise.tryFail(e)
            }
        }
    }

    private fun <T : ResultType> parseResponse(
        response: AsyncResult<HttpResponse<Buffer>>,
        resultType: Class<T>
    ): T =
        response
            .takeIf { it.succeeded() }?.let {
                mapper.readValue(it.result().bodyAsString(), resultType).let {
                    it.takeIf { it.ok } ?: throw TelegramRequestFail(
                        errorCode = it.errorCode ?: -1,
                        description = it.description ?: "No description."
                    )
                }
            } ?: throw response.cause()
}


fun defaultTimeout(command: String, args: List<Pair<String, Any?>>): Long =
    when (command) {
        "getUpdates" -> ((args.toMap()["timeout"] as? Int ?: 25) + 5) * 1000L
        else -> 30 * 1000L
    }
