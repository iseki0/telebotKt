import io.vertx.core.AbstractVerticle
import io.vertx.core.Future

class BotVerticle : AbstractVerticle() {
    override fun start(startFuture: Future<Void>?) {
        config()
    }

}