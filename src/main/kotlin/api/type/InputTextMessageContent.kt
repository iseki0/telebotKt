@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content](https://core.telegram.org#inputmessagecontent) of a text message to be sent as the result of an inline query.
 *
 * @param[messageText] Text of the message to be sent, 1-4096 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in your bot's message.
 * @param[disableWebPagePreview] *Optional*. Disables link previews for links in the sent message
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputTextMessageContent @JsonCreator constructor(
    @get:JsonProperty("message_text")
    @JsonProperty("message_text")
    val messageText: String,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: String? = null,
    @get:JsonProperty("disable_web_page_preview")
    @JsonProperty("disable_web_page_preview")
    val disableWebPagePreview: Boolean? = null
) : InputMessageContent