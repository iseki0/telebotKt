import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)


class BotContext(val botServer: BotServer){

    fun <R> awsl(req:BotRequest):Future<R>{
        return Future.future { TODO() }
    }
}