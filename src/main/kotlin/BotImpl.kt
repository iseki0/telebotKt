import api.ResultType
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

    private val thread = Thread.currentThread()
    val context = vertx.orCreateContext
    val webClient = WebClient.create(vertx, botOption.webClientOptions)!!
    val urlGenerator = botOption.botServerInfo.urlGenerator
    override val mapper: ObjectMapper by lazy {
        check(thread == Thread.currentThread()) { "mapper is init in wrong thread. current: ${Thread.currentThread()}, correct: $thread" }
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
        if (response.failed()) {
            throw response.cause()
        } else {
            val r = mapper.readValue(response.result().bodyAsString(), resultType)
            if (r.ok) r else throw TelegramRequestFail(r)
        }
}


fun defaultTimeout(command: String, args: List<Pair<String, Any?>>): Long =
    when (command) {
        "getUpdates" -> ((args.toMap()["timeout"] as? Int ?: 25) + 5) * 1000L
        else -> 30 * 1000L
    }
