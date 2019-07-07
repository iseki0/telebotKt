package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a link to a file stored on the Telegram servers. By default, this file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the file.
 * **Note:** This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.
 *
 * @param[type] Type of the result, must be *document*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[title] Title for the result
 * @param[documentFileId] A valid file identifier for the file
 * @param[description] *Optional*. Short description of the result
 * @param[caption] *Optional*. Caption of the document to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the file
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultCachedDocument @JsonCreator constructor(
    @ValueMustBe("document")
    @JsonProperty("type")
    val type: String = "document",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("document_file_id")
    val documentFileId: String,
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