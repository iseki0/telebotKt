import io.vertx.core.Future
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.multipart.MultipartForm
import types.InputFile
import types.Update

class BotServerImpl(
    val vertx: Vertx,
    val config: BotConfig,
    val httpClient: WebClient,
    val httpServer: HttpServer
) : BotServer {

    val baseUrl = "https://api.telegram.org/bot${config.botKey}/"
    val context = BotContext(botServer = this, httpTimeout = 10000)
    var updateHandler: Handler<Update>? = null
    var lastUpdateId = 0
    var lastUpdateTimerId = 0L

    fun start(): Future<Unit> = Future.future { promise ->
        lastUpdateTimerId = doPollUpdate()
        promise.complete()
    }

    fun doPollUpdate(): Long =
        vertx.setTimer(config.pollingDelay) {
            context.getUpdates(offset = lastUpdateId + 1, timeout = config.pollingTimeout).setHandler {
                lastUpdateTimerId = doPollUpdate()
                if (it.succeeded()) {
                    log { "new message: ${it.result()?.size ?: "null"}" }
                    it.result()?.let { resolveUpdates(it) }
                } else {
                    log { it.cause().message ?: it.cause().toString() }
                }
            }
        }


    fun resolveUpdates(updates: Array<Update>) {
        updates.forEach {
            if (it.updateId > lastUpdateId) {
                // this is a new message
                lastUpdateId = it.updateId
                updateHandler?.handle(it)
            } else {
                log { "Receive Old Message." }
            }
        }
    }

    override fun sendRequest(req: BotRequest, context: BotContext): Future<JsonObject> {
        val url = baseUrl + req.api
        val request = httpClient.postAbs(url)
        val promise = Promise.promise<JsonObject>()
        if (checkNeedForm(req) || true) {
            val form = MultipartForm.create()
            req.pairs.forEach { (key, value) ->
                if (value is InputFile) {
                    TODO()
                } else {
                    form.attribute(
                        key,
                        if (checkSimpleType(value)) value.toString() else JsonObject.mapFrom(value).encode()
                    )
                }
            }

            request.sendMultipartForm(form) {
                if (it.succeeded()) {
                    try {
                        val json = it.result().bodyAsJsonObject()
                        if (json.getBoolean("ok")) {
                            promise.complete(json)
                        } else {
                            promise.fail(
                                TelegramRequestException(
                                    request = req,
                                    errorCode = json.getInteger("error_code", -1),
                                    description = json.getString("description", "")
                                )
                            )
                        }
                    } catch (e: Exception) {
                        promise.fail(e)
                    }
                } else {
                    promise.fail(it.cause())
                }
            }
        }
        return promise.future()
    }

}

data class BotConfig(
    val botKey: String,
    val localListenPort: Int = 8080,
    val needSetWebhook: Boolean = false,
    val webhookUrl: String = "",
    val certificate: String? = null,
    val pollingDelay: Long = 500L,
    val pollingTimeout: Int = 10
)


inline fun log(msg: () -> String) {
    println(msg())
}

class TelegramRequestException(
    val request: BotRequest? = null,
    val errorCode: Int = 0,
    val description: String = "",
    cause: Throwable? = null
) : RuntimeException("$errorCode: $description", cause)

fun checkNeedForm(req: BotRequest): Boolean =
    req.pairs.find { it.second is InputFile }?.run { true } ?: false

fun checkSimpleType(obj: Any?): Boolean =
    when (obj) {
        null -> true
        is String -> true
        is Int -> true
        is Long -> true
        is Boolean -> true
        else -> false
    }

