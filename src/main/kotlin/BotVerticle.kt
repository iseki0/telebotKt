import io.vertx.core.*
import io.vertx.core.http.HttpServer
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.client.WebClient

class BotVerticle : AbstractVerticle() {
    lateinit var webClient:WebClient
    lateinit var httpServer: HttpServer
    override fun start(startFuture: Future<Void>?) {
        val begin=Promise.succeededPromise<Unit>()
        begin.future().compose {
            // convert Config
            Promise.succeededPromise(config().mapTo(BotVerticleConfig::class.java)).future()
        }.compose {
            Promise.succeededPromise<Int>().future()
        }
    }

    private fun registerWebHook(){}

}