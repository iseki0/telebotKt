package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a voice message stored on the Telegram servers. By default, this voice message will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the voice message.
 * **Note:** This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.
 *
 * @param[type] Type of the result, must be *voice*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[voiceFileId] A valid file identifier for the voice message
 * @param[title] types.Voice message title
 * @param[caption] *Optional*. Caption, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the voice message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultCachedVoice @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("voice_file_id")
    val voiceFileId: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("caption")
    val caption: String?,
    @JsonProperty("parse_mode")
    val parseMode: String?,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup?,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent?
)