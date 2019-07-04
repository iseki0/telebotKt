package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a photo stored on the Telegram servers. By default, this photo will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the photo.
 *
 * @param[type] Type of the result, must be *photo*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[photoFileId] A valid file identifier of the photo
 * @param[title] *Optional*. Title for the result
 * @param[description] *Optional*. Short description of the result
 * @param[caption] *Optional*. Caption of the photo to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the photo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultCachedPhoto @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("photo_file_id")
    val photoFileId: String,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("caption")
    val caption: String?,
    @JsonProperty("parse_mode")
    val parseMode: String?,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup?,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent?
)