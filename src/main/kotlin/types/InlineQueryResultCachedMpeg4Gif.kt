package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound) stored on the Telegram servers. By default, this animated MPEG-4 file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the animation.
 *
 * @param[type] Type of the result, must be *mpeg4_gif*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[mpeg4FileId] A valid file identifier for the MP4 file
 * @param[title] *Optional*. Title for the result
 * @param[caption] *Optional*. Caption of the MPEG-4 file to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the video animation
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultCachedMpeg4Gif @JsonCreator constructor(
    @ValueMustBe("mpeg4_gif")
    @JsonProperty("type")
    val type: String = "mpeg4_gif",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("mpeg4_file_id")
    val mpeg4FileId: FileId,
    @JsonProperty("title")
    val title: String? = null,
    @JsonProperty("caption")
    val caption: String? = null,
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult