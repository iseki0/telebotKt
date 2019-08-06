import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpServer
import io.vertx.core.json.JsonObject
import types.Update

class BotServerImpl constructor(
    val vertx: Vertx,
    val config: BotConfig,
    val httpClient: HttpClient,
    val httpServer: HttpServer
) : BotServer {
    val baseUrl = "https://api.telegram.org/bot${config.botKey}/"
    val context = BotContext(this)

    var lastUpdateId = 0

    fun start(): Future<Unit> = Future.future { promise ->
        doPollUpdate()
        promise.complete()
    }

    fun doPollUpdate() {
        vertx.setTimer(config.pollingDelay) {
            context.getUpdates(offset = lastUpdateId + 1).setHandler {
                doPollUpdate()
                if (it.succeeded()) {
                    log { "new message: ${it.result()?.size ?: "null"}" }
                    it.result()?.let { resolveUpdates(it) }
                } else {
                    println("ERROR")
                    println(it.cause().message)
                    //it.cause().printStackTrace()
                }
            }
        }
    }

    fun resolveUpdates(updates: Array<Update>) {
        updates.forEach {
            if (it.updateId > lastUpdateId) {
                // this is a new message
                lastUpdateId = it.updateId
                println(it)
                println("ssssss")
                //println(JsonObject.mapFrom(it).encode())
            } else {
                println("old message")
            }
        }
        TODO()
    }

    override fun sendRequest(req: BotRequest): Future<JsonObject> {
        log { "Send request: ${req.api}" }
        val request = httpClient.postAbs(baseUrl + req.api)
        val result = request.compose {
            log { "Receive response of ${req.api}, ${it.statusCode()} - ${it.statusMessage()}" }
            it.body()
        }.compose {
            log { "length: ${it.length()}" }
            Future.succeededFuture(it.toJsonObject())
        }.compose<JsonObject> {
            if (it.getBoolean("ok")) {
                Future.succeededFuture(it)
            } else {
                throw TelegramRequestException(
                    request = req,
                    errorCode = it.getInteger("error_code"),
                    description = it.getString("description")
                )
            }
        }
        request.putHeader("Content-Type", "application/json")
            .end(req.jsonObject.encode())
        return result
    }


}

data class BotConfig(
    val botKey: String,
    val localListenPort: Int = 8080,
    val needSetWebhook: Boolean = false,
    val webhookUrl: String = "",
    val certificate: String? = null,
    val pollingDelay: Long = 500L,
    val pollingTimeout: Int = 10000
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
