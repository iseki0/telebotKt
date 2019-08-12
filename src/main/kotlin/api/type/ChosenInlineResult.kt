@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a [result](https://core.telegram.org#inlinequeryresult) of an inline query that was chosen by the user and sent to their chat partner.
 *
 * @param[resultId] The unique identifier for the result that was chosen
 * @param[from] The user that chose the result
 * @param[location] *Optional*. Sender location, only for bots that require user location
 * @param[inlineMessageId] *Optional*. Identifier of the sent inline message. Available only if there is an [inline keyboard][InlineKeyboardMarkup] attached to the message. Will be also received in [callback queries][CallbackQuery] and can be used to [edit](https://core.telegram.org#updating-messages) the message.
 * @param[query] The query that was used to obtain the result
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChosenInlineResult @JsonCreator constructor(
    @get:JsonProperty("result_id")
    @JsonProperty("result_id")
    val resultId: String,
    @get:JsonProperty("from")
    @JsonProperty("from")
    val from: User,
    @get:JsonProperty("location")
    @JsonProperty("location")
    val location: Location? = null,
    @get:JsonProperty("inline_message_id")
    @JsonProperty("inline_message_id")
    val inlineMessageId: String? = null,
    @get:JsonProperty("query")
    @JsonProperty("query")
    val query: String
)