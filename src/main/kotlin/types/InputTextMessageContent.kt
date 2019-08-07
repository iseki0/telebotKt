package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content][InputMessageContent] of a text message to be sent as the result of an inline query.
 *
 * @param[messageText] Text of the message to be sent, 1-4096 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in your bot's message.
 * @param[disableWebPagePreview] *Optional*. Disables link previews for links in the sent message
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputTextMessageContent @JsonCreator constructor(
    @JsonProperty("message_text")
    val messageText: String,
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @JsonProperty("disable_web_page_preview")
    val disableWebPagePreview: Boolean? = null
) : InputMessageContent