data class BotRequest(
    val api: String,
    val pairs: List<Pair<String, Any?>>
)


//fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
//    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, pairs.toList().filterNot { it.second == null })

fun <T> basicTypeNeednotMapTo(type: Class<T>): Boolean =
    when {
        type.isInstance(true) -> true
        type.isInstance("") -> true
        type.isInstance(0) -> true
        else -> false
    }
