import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import deserializer.FieldExistDeserializer
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.core.json.JsonObject
import types.*

fun main() {
    Json.mapper.registerKotlinModule()
    Json.mapper.registerKotlinModule()
    val vertx = Vertx.vertx()
    println("Hello world.")

    val a = FieldExistDeserializer.create(
        listOf(
            InlineQueryResultArticle::class.java,
            InlineQueryResultAudio::class.java,
            InlineQueryResultCachedAudio::class.java,
            InlineQueryResultCachedDocument::class.java,
            InlineQueryResultCachedGif::class.java,
            InlineQueryResultCachedMpeg4Gif::class.java,
            InlineQueryResultCachedPhoto::class.java,
            InlineQueryResultCachedSticker::class.java,
            InlineQueryResultCachedVideo::class.java,
            InlineQueryResultCachedVoice::class.java,
            InlineQueryResultContact::class.java,
            InlineQueryResultDocument::class.java,
            InlineQueryResultGame::class.java,
            InlineQueryResultGif::class.java,
            InlineQueryResultLocation::class.java,
            InlineQueryResultMpeg4Gif::class.java,
            InlineQueryResultPhoto::class.java,
            InlineQueryResultVenue::class.java,
            InlineQueryResultVideo::class.java,
            InlineQueryResultVoice::class.java
        )
    )
}


fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)
