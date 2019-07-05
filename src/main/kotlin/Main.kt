import io.vertx.core.json.JsonObject

fun main() {
    println(JsonObject(mapOf(Pair("a", null)).filterNot { it.value == null }))


}

fun aa(a: String): JsonObject = JsonObject(mapOf(Pair("a", 5)))

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)
