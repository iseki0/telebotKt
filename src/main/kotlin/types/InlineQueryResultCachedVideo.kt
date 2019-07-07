package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a link to a video file stored on the Telegram servers. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the video.
 *
 * @param[type] Type of the result, must be *video*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[videoFileId] A valid file identifier for the video file
 * @param[title] Title for the result
 * @param[description] *Optional*. Short description of the result
 * @param[caption] *Optional*. Caption of the video to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the video
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultCachedVideo @JsonCreator constructor(
    @ValueMustBe("video")
    @JsonProperty("type")
    val type: String = "video",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("video_file_id")
    val videoFileId: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("caption")
    val caption: String? = null,
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult