package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound). By default, this animated MPEG-4 file will be sent by the user with optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the animation.
 *
 * @param[type] Type of the result, must be *mpeg4_gif*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[mpeg4Url] A valid URL for the MP4 file. types.File size must not exceed 1MB
 * @param[mpeg4Width] *Optional*. types.Video width
 * @param[mpeg4Height] *Optional*. types.Video height
 * @param[mpeg4Duration] *Optional*. types.Video duration
 * @param[thumbUrl] URL of the static thumbnail (jpeg or gif) for the result
 * @param[title] *Optional*. Title for the result
 * @param[caption] *Optional*. Caption of the MPEG-4 file to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the video animation
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultMpeg4Gif @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("mpeg4_url")
    val mpeg4Url: String,
    @JsonProperty("mpeg4_width")
    val mpeg4Width: Int?,
    @JsonProperty("mpeg4_height")
    val mpeg4Height: Int?,
    @JsonProperty("mpeg4_duration")
    val mpeg4Duration: Int?,
    @JsonProperty("thumb_url")
    val thumbUrl: String,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("caption")
    val caption: String?,
    @JsonProperty("parse_mode")
    val parseMode: String?,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup?,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent?
)