import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import deserializer.DDDeserializer
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.core.json.JsonObject
import types.*

fun main() {
    registerObjectMapperModule(Json.mapper)
    //registerObjectMapperModule(Json.prettyMapper)

    val aa = InlineQueryResultArticle(
        inputMessageContent = InputLocationMessageContent(0f, 0f),
        id = "IDID",
        title = "TITLETT"
    )
    println(JsonObject.mapFrom(aa).mapTo(InlineQueryResult::class.java))
    val vertx = Vertx.vertx()
    vertx.deployVerticle(BotVerticle()) {
        if (it.succeeded()) {
            println("deploy success")
        } else {
            vertx.close()
            it.cause().printStackTrace()
        }
    }
    println("Hello world.")
}


fun registerObjectMapperModule(mapper: ObjectMapper) {
    val inlineQueryResultDeserializer = DDDeserializer.create(
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
    val inputMessageContentDeserializer = DDDeserializer.create(
        listOf(
            InputLocationMessageContent::class.java,
            InputVenueMessageContent::class.java,
            InputTextMessageContent::class.java,
            InputContactMessageContent::class.java
        )
    )
    mapper.registerKotlinModule()
        .registerModule(
            SimpleModule()
                .addDeserializer(InlineQueryResult::class.java, inlineQueryResultDeserializer)
                .addDeserializer(InputMessageContent::class.java, inputMessageContentDeserializer)
        )
}