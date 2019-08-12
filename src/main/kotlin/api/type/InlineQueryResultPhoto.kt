@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a photo. By default, this photo will be sent by the user with optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the photo.
 *
 * @param[type] Type of the result, must be *photo*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[photoUrl] A valid URL of the photo. Photo must be in **jpeg** format. Photo size must not exceed 5MB
 * @param[thumbUrl] URL of the thumbnail for the photo
 * @param[photoWidth] *Optional*. Width of the photo
 * @param[photoHeight] *Optional*. Height of the photo
 * @param[title] *Optional*. Title for the result
 * @param[description] *Optional*. Short description of the result
 * @param[caption] *Optional*. Caption of the photo to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the photo
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultPhoto @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("photo_url")
    @JsonProperty("photo_url")
    val photoUrl: String,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String,
    @get:JsonProperty("photo_width")
    @JsonProperty("photo_width")
    val photoWidth: Int? = null,
    @get:JsonProperty("photo_height")
    @JsonProperty("photo_height")
    val photoHeight: Int? = null,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String? = null,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String? = null,
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