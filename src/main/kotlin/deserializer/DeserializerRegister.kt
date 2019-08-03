package deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import types.*


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