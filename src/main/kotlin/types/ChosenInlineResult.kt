package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a [result][InlineQueryResult] of an inline query that was chosen by the user and sent to their chat partner.
 * **Note:** It is necessary to enable [inline feedback](https://core.telegram.org/bots/inline#collecting-feedback) via [@Botfather](https://t.me/botfather) in order to receive these objects in updates.
 * Your bot can accept payments from Telegram users. Please see the [introduction to payments](https://core.telegram.org/bots/payments) for more details on the process and how to set up payments for your bot. Please note that users will need Telegram v.4.0 or higher to use payments (released on May 18, 2017).
 *
 * @param[resultId] The unique identifier for the result that was chosen
 * @param[from] The user that chose the result
 * @param[location] *Optional*. Sender location, only for bots that require user location
 * @param[inlineMessageId] *Optional*. Identifier of the sent inline message. Available only if there is an [inline keyboard][InlineKeyboardMarkup] attached to the message. Will be also received in [callback queries][CallbackQuery] and can be used to [edit][null] the message.
 * @param[query] The query that was used to obtain the result
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChosenInlineResult @JsonCreator constructor(
    @JsonProperty("result_id")
    val resultId: String,
    @JsonProperty("from")
    val from: User,
    @JsonProperty("location")
    val location: Location? = null,
    @JsonProperty("inline_message_id")
    val inlineMessageId: String? = null,
    @JsonProperty("query")
    val query: String
)