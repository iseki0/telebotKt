import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.json.JsonObject
import types.Update

class BotServer private constructor(
    val vertx: Vertx,
    val config: BotConfig,
    val httpClient: HttpClient,
    val httpServer: HttpServer
) {
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
                    //it.cause().printStackTrace()
                    println("ERROR")
                    println(it.cause().message)
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

    fun sendRequest(req: BotRequest): Future<JsonObject> = Future.future { promise ->
        log { "Send request: ${req.api}" }
        val request = httpClient.postAbs(baseUrl + req.api)
        val requestFuture = request.putHeader("Content-Type", "application/json")
        request.compose {
            log { "Receive response of ${req.api}, ${request.result().statusCode()} - ${request.result().statusMessage()}" }
            request.result().body()
        }.compose {
            log { "length: ${it.length()}" }
            Future.succeededFuture(it.toJsonObject())
        }.setHandler {
            if (it.succeeded()) {
                promise.complete(it.result())
            } else {
                promise.fail(it.cause())
            }
        }
        // send request
        requestFuture.end(req.jsonObject.encode())
    }


    companion object {
        fun create(
            vertx: Vertx,
            botConfig: BotConfig,
            httpClient: HttpClient = defaultHttpClient(vertx),
            httpServer: HttpServer = defaultHttpServer(vertx, botConfig)
        ): BotServer = BotServer(vertx, botConfig, httpClient, httpServer)

        private fun defaultHttpServer(vertx: Vertx, botConfig: BotConfig): HttpServer =
            vertx.createHttpServer(HttpServerOptions().setPort(botConfig.localListenPort))

        private fun defaultHttpClient(vertx: Vertx): HttpClient =
            vertx.createHttpClient()
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
