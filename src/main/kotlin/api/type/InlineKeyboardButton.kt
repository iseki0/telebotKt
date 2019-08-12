@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.CallbackGame
import api.func.answerInlineQuery
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one button of an inline keyboard. You **must** use exactly one of the optional fields.
 *
 * @param[text] Label text on the button
 * @param[url] *Optional*. HTTP or tg:// url to be opened when button is pressed
 * @param[loginUrl] *Optional*. An HTTP URL used to automatically authorize the user. Can be used as a replacement for the [Telegram Login Widget](https://core.telegram.org/widgets/login).
 * @param[callbackData] *Optional*. Data to be sent in a [callback query][CallbackQuery] to the bot when button is pressed, 1-64 bytes
 * @param[switchInlineQuery] *Optional*. If set, pressing the button will prompt the user to select one of their chats, open that chat and insert the bot‘s username and the specified inline query in the input field. Can be empty, in which case just the bot’s username will be inserted.**Note:** This offers an easy way for users to start using your bot in [inline mode](https://core.telegram.org/bots/inline) when they are currently in a private chat with it. Especially useful when combined with [*switch_pm…*][answerInlineQuery] actions – in this case the user will be automatically returned to the chat they switched from, skipping the chat selection screen.
 * @param[switchInlineQueryCurrentChat] *Optional*. If set, pressing the button will insert the bot‘s username and the specified inline query in the current chat's input field. Can be empty, in which case only the bot’s username will be inserted.This offers a quick way for the user to open your bot in inline mode in the same chat – good for selecting something from multiple options.
 * @param[callbackGame] *Optional*. Description of the game that will be launched when the user presses the button.**NOTE:** This type of button **must** always be the first button in the first row.
 * @param[pay] *Optional*. Specify True, to send a [Pay button](https://core.telegram.org#payments).**NOTE:** This type of button **must** always be the first button in the first row.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineKeyboardButton @JsonCreator constructor(
    @get:JsonProperty("text")
    @JsonProperty("text")
    val text: String,
    @get:JsonProperty("url")
    @JsonProperty("url")
    val url: String? = null,
    @get:JsonProperty("login_url")
    @JsonProperty("login_url")
    val loginUrl: LoginUrl? = null,
    @get:JsonProperty("callback_data")
    @JsonProperty("callback_data")
    val callbackData: String? = null,
    @get:JsonProperty("switch_inline_query")
    @JsonProperty("switch_inline_query")
    val switchInlineQuery: String? = null,
    @get:JsonProperty("switch_inline_query_current_chat")
    @JsonProperty("switch_inline_query_current_chat")
    val switchInlineQueryCurrentChat: String? = null,
    @get:JsonProperty("callback_game")
    @JsonProperty("callback_game")
    val callbackGame: CallbackGame? = null,
    @get:JsonProperty("pay")
    @JsonProperty("pay")
    val pay: Boolean? = null
)