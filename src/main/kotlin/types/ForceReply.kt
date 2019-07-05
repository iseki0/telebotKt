package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice [privacy mode](https://core.telegram.org/bots#privacy-mode).
 * **Example:** A [poll bot](https://t.me/PollBot) for groups runs in privacy mode (only receives commands, replies to its messages and mentions). There could be two ways to create a new poll:
 * The last option is definitely more attractive. And if you use [types.ForceReply][ForceReply] in your bot‘s questions, it will receive the user’s answers even if it only receives replies, commands and mentions — without any extra work for the user.
 *
 * @param[forceReply] Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
 * @param[selective] *Optional*. Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the *text* of the [types.Message][Message] object; 2) if the bot's message is a reply (has *reply_to_message_id*), sender of the original message.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ForceReply @JsonCreator constructor(
    @JsonProperty("force_reply")
    val forceReply: Boolean,
    @JsonProperty("selective")
    val selective: Boolean?
) : ReplyMarkup