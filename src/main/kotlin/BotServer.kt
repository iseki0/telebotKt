import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
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

    fun start(): Future<Unit> = TODO()

    inline fun <reified T> awsl(req: BotRequest): Future<T> {
        return Future.future { promise ->
            sendRequest(req).setHandler {
                if (it.succeeded()) {
                    promise.complete(it.result().mapTo(T::class.java))
                } else {
                    promise.fail(it.cause())
                }
            }
        }
    }

    fun sendRequest(req: BotRequest): Future<JsonObject> {
        return Future.future { promise ->
            val request = httpClient.post(baseUrl + req.api) { response ->
                val buffer = Buffer.buffer()
                response.bodyHandler { buffer.appendBuffer(it) }
                response.endHandler {
                    if (response.statusCode() == 200) {
                        promise.complete(buffer.toJsonObject())
                    } else {
                        val json = buffer.toJsonObject()
                        promise.fail(BotRequestException(response.statusCode(), json.getString("description")))
                    }
                }
            }
            request.putHeader("Content-Type", "application/json").write(req.jsonObject.toBuffer()).end()
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
    val certificate: String? = null
)

class BotRequestException(val statusCode: Int, val description: String) : RuntimeException()