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
    fun start(): Future<Unit> {
        val future = Future.future<Unit> { promise ->
            httpServer.listen {
                if (it.succeeded())
                    promise.complete()
                else
                    promise.fail(it.cause())
            }
        }.compose {
            // set Webhook
            sendRequest(setWebhook(url = config.webhookUrl))
        }.compose {
            if (it.getString("ok") == "true") {
                Future.succeededFuture<Unit>()
            } else {
                throw RuntimeException("Bot setWebhook fail[${it.getInteger("error_code")}]: ${it.getString("description")}")
            }
        }
        return future
    }

    fun sendRequest(req: BotRequest): Future<JsonObject> {
        TODO()
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
    val certificate: String? = null
)