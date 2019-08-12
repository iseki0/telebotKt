@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an incoming callback query from a callback button in an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If the button that originated the query was attached to a message sent by the bot, the field *message* will be present. If the button was attached to a message sent via the bot (in [inline mode](https://core.telegram.org#inline-mode)), the field *inline_message_id* will be present. Exactly one of the fields *data* or *game_short_name* will be present.
 *
 * @param[id] Unique identifier for this query
 * @param[from] Sender
 * @param[message] *Optional*. Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
 * @param[inlineMessageId] *Optional*. Identifier of the message sent via the bot in inline mode, that originated the query.
 * @param[chatInstance] Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in [games](https://core.telegram.org#games).
 * @param[data] *Optional*. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
 * @param[gameShortName] *Optional*. Short name of a [Game](https://core.telegram.org#games) to be returned, serves as the unique identifier for the game
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CallbackQuery @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("from")
    @JsonProperty("from")
    val from: User,
    @get:JsonProperty("message")
    @JsonProperty("message")
    val message: Message? = null,
    @get:JsonProperty("inline_message_id")
    @JsonProperty("inline_message_id")
    val inlineMessageId: String? = null,
    @get:JsonProperty("chat_instance")
    @JsonProperty("chat_instance")
    val chatInstance: String,
    @get:JsonProperty("data")
    @JsonProperty("data")
    val data: String? = null,
    @get:JsonProperty("game_short_name")
    @JsonProperty("game_short_name")
    val gameShortName: String? = null
)