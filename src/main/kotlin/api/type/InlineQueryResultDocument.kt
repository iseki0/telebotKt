@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a file. By default, this file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the file. Currently, only **.PDF** and **.ZIP** files can be sent using this method.
 *
 * @param[type] Type of the result, must be *document*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[title] Title for the result
 * @param[caption] *Optional*. Caption of the document to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[documentUrl] A valid URL for the file
 * @param[mimeType] Mime type of the content of the file, either “application/pdf” or “application/zip”
 * @param[description] *Optional*. Short description of the result
 * @param[replyMarkup] *Optional*. Inline keyboard attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the file
 * @param[thumbUrl] *Optional*. URL of the thumbnail (jpeg only) for the file
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultDocument @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: String? = null,
    @get:JsonProperty("document_url")
    @JsonProperty("document_url")
    val documentUrl: String,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String? = null,
    @get:JsonProperty("thumb_width")
    @JsonProperty("thumb_width")
    val thumbWidth: Int? = null,
    @get:JsonProperty("thumb_height")
    @JsonProperty("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult