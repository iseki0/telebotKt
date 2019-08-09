import io.vertx.core.Future
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.client.WebClient

interface BotServer {
    fun sendRequest(req: BotRequest, context: BotContext): Future<JsonObject>

    companion object {
        fun create(
            vertx: Vertx,
            botConfig: BotConfig,
            httpClient: WebClient = defaultHttpClient(vertx),
            httpServer: HttpServer = defaultHttpServer(vertx, botConfig)
        ): BotServerImpl = BotServerImpl(vertx, botConfig, httpClient, httpServer)

        private fun defaultHttpServer(vertx: Vertx, botConfig: BotConfig): HttpServer =
            vertx.createHttpServer(HttpServerOptions().setPort(botConfig.localListenPort))

        private fun defaultHttpClient(vertx: Vertx): WebClient =
            WebClient.create(vertx)
    }
}

enum class RequestMethod {
    JSON, FORM
}