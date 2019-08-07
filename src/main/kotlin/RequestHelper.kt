import io.vertx.core.json.JsonObject


data class BotRequest(val api: String, val jsonObject: JsonObject)


fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

fun <T> basicTypeNeednotMapTo(type: Class<T>): Boolean =
    when {
        type.isInstance(true) -> true
        type.isInstance("") -> true
        type.isInstance(0) -> true
        else -> false
    }
