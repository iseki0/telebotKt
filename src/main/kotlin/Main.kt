import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import deserializer.FieldExistDeserializer
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import types.*

fun main() {
    registerObjectMapperModule(Json.mapper)
    registerObjectMapperModule(Json.prettyMapper)
    val vertx = Vertx.vertx()

    println("Hello world.")
}


fun registerObjectMapperModule(mapper: ObjectMapper) {
    val inlineQueryResultDeserializer = FieldExistDeserializer.create(
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
    mapper.registerKotlinModule()
        .registerModule(SimpleModule().addDeserializer(InlineQueryResult::class.java, inlineQueryResultDeserializer))
}