import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)


class TgBot(private val vertx: Vertx, private val msgId: String) {
    fun sendReq(request: BotRequest): Future<JsonObject> {
        val promise = Promise.promise<JsonObject>()
        vertx.eventBus().request<JsonObject>(msgId, request) {
            if (it.succeeded()) {
                promise.complete(it.result().body())
            } else {
                promise.fail(it.cause())
            }
        }
        return promise.future()
    }
}