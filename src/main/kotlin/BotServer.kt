import io.vertx.core.CompositeFuture
import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.json.JsonObject

class BotServer private constructor(
    val vertx: Vertx,
    val config: BotConfig,
    val httpClient: HttpClient,
    val httpServer: HttpServer
) {
    val baseUrl = "https://api.telegram.org/bot${config.botKey}/"
    val context = BotContext(this)
    fun start(): Future<Unit> = Future.future { promise ->

    }

    fun createPollingLoop() {
        context.getUpdates()
    }

    fun sendRequest(req: BotRequest): Future<JsonObject> = Future.future { promise ->
        val request = httpClient.post(baseUrl + req.api)
        val requestFuture = request.putHeader("Content-Type", "application/json").end(req.jsonObject.encode())

        CompositeFuture.all(request, requestFuture).compose {
            request.result().body()
        }.compose {
            Future.succeededFuture(it.toJsonObject())
        }.setHandler {
            if (it.succeeded()) {
                promise.complete(it.result())
            } else {
                promise.fail(it.cause())
            }
        }
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
    val pollDelay: Long = 500L
)

