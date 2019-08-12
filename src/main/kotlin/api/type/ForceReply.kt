@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.ReplyMarkup
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice [privacy mode](https://core.telegram.org/bots#privacy-mode).
 *
 * @param[forceReply] Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
 * @param[selective] *Optional*. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the *text* of the [Message][Message] object; 2) if the bot's message is a reply (has *reply_to_message_id*), sender of the original message.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ForceReply @JsonCreator constructor(
    @get:JsonProperty("force_reply")
    @JsonProperty("force_reply")
    val forceReply: Boolean,
    @get:JsonProperty("selective")
    @JsonProperty("selective")
    val selective: Boolean? = null
) : ReplyMarkup