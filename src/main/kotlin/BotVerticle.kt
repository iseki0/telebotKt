import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.eventbus.Message
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.client.WebClient

class BotVerticle : AbstractVerticle() {
    lateinit var webClient:WebClient
    lateinit var httpServer: HttpServer
    lateinit var botConfig: BotVerticleConfig
    lateinit var baseUrl: String
    override fun start(startFuture: Future<Void>?) {
        val begin=Promise.succeededPromise<Unit>()
        begin.future().compose {
            // convert Config
            botConfig = config().mapTo(BotVerticleConfig::class.java)
            baseUrl = "https://api.telegram.org/bot${botConfig.botToken}/"
            println("Aaaa")
            Promise.succeededPromise<Unit>().future()
        }.compose {
            // create http server for message updates.
            val listenFuture = Promise.promise<HttpServer>()
            httpServer = vertx.createHttpServer(HttpServerOptions().setPort(botConfig.webhookLocalPort))
            httpServer.listen(listenFuture.future())
            listenFuture.future()
        }.compose {
            // create consumer for request
            vertx.eventBus().consumer<BotRequest>(botConfig.botMsgId) { handleMsg(it) }
            Future.succeededFuture(TgBot(vertx, botConfig.botMsgId))
        }.compose {
            // set webhook on Telegram
            webClient = WebClient.create(vertx)
            val aa = setWebhook(botConfig.webhookUrl)
            it.sendReq(setWebhook(botConfig.webhookUrl))
        }.setHandler {
            // handle result of `setWebhook`
            if (it.succeeded()) {
                startFuture?.succeeded()
            } else {
                startFuture?.fail(it.cause())
            }
        }
    }

    private fun handleMsg(msg: Message<BotRequest>) {
        val req = msg.body()
        webClient.get(baseUrl + req.api).sendJson(req.jsonObject) {
            if (it.succeeded()) {

            }
        }
        TODO()
    }
    private fun registerWebHook(){}

}

class RequestFailException(val errorCode: Int, val description: String) :
    RuntimeException("Request fail[$errorCode]: $description")