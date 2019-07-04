package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the animation.
 *
 * @param[type] Type of the result, must be *gif*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[gifUrl] A valid URL for the GIF file. types.File size must not exceed 1MB
 * @param[gifWidth] *Optional*. Width of the GIF
 * @param[gifHeight] *Optional*. Height of the GIF
 * @param[gifDuration] *Optional*. Duration of the GIF
 * @param[thumbUrl] URL of the static thumbnail for the result (jpeg or gif)
 * @param[title] *Optional*. Title for the result
 * @param[caption] *Optional*. Caption of the GIF file to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the GIF animation
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultGif @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("gif_url")
    val gifUrl: String,
    @JsonProperty("gif_width")
    val gifWidth: Int?,
    @JsonProperty("gif_height")
    val gifHeight: Int?,
    @JsonProperty("gif_duration")
    val gifDuration: Int?,
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