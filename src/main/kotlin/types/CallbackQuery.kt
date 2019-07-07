package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an incoming callback query from a callback button in an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If the button that originated the query was attached to a message sent by the bot, the field *message* will be present. If the button was attached to a message sent via the bot (in [inline mode][null]), the field *inline_message_id* will be present. Exactly one of the fields *data* or *game_short_name* will be present.
 * **NOTE:** After the user presses a callback button, Telegram clients will display a progress bar until you call [answerCallbackQuery][answerCallbackQuery]. It is, therefore, necessary to react by calling [answerCallbackQuery][answerCallbackQuery] even if no notification to the user is needed (e.g., without specifying any of the optional parameters).
 *
 * @param[id] Unique identifier for this query
 * @param[from] Sender
 * @param[message] *Optional*. types.Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
 * @param[inlineMessageId] *Optional*. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @param[chatInstance] Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in [games][null].
 * @param[data] *Optional*. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
 * @param[gameShortName] *Optional*. Short name of a [types.Game][null] to be returned, serves as the unique identifier for the game
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CallbackQuery @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("from")
    val from: User,
    @JsonProperty("message")
    val message: Message? = null,
    @JsonProperty("inline_message_id")
    val inlineMessageId: String? = null,
    @JsonProperty("chat_instance")
    val chatInstance: String,
    @JsonProperty("data")
    val data: String? = null,
    @JsonProperty("game_short_name")
    val gameShortName: String? = null
)