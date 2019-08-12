@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to an animated GIF file. By default, this animated GIF file will be sent by the user with optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the animation.
 *
 * @param[type] Type of the result, must be *gif*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[gifUrl] A valid URL for the GIF file. File size must not exceed 1MB
 * @param[gifWidth] *Optional*. Width of the GIF
 * @param[gifHeight] *Optional*. Height of the GIF
 * @param[gifDuration] *Optional*. Duration of the GIF
 * @param[thumbUrl] URL of the static thumbnail for the result (jpeg or gif)
 * @param[title] *Optional*. Title for the result
 * @param[caption] *Optional*. Caption of the GIF file to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the GIF animation
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultGif @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("gif_url")
    @JsonProperty("gif_url")
    val gifUrl: String,
    @get:JsonProperty("gif_width")
    @JsonProperty("gif_width")
    val gifWidth: Int? = null,
    @get:JsonProperty("gif_height")
    @JsonProperty("gif_height")
    val gifHeight: Int? = null,
    @get:JsonProperty("gif_duration")
    @JsonProperty("gif_duration")
    val gifDuration: Int? = null,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String? = null,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: String? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult