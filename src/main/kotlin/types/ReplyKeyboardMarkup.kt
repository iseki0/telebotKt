package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a [custom keyboard](https://core.telegram.org/bots#keyboards) with reply options (see [Introduction to bots](https://core.telegram.org/bots#keyboards) for details and examples).
 *
 * @param[keyboard] Array of button rows, each represented by an Array of [types.KeyboardButton][KeyboardButton] objects
 * @param[resizeKeyboard] *Optional*. Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to *false*, in which case the custom keyboard is always of the same height as the app's standard keyboard.
 * @param[oneTimeKeyboard] *Optional*. Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to *false*.
 * @param[selective] *Optional*. Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the *text* of the [types.Message][Message] object; 2) if the bot's message is a reply (has *reply_to_message_id*), sender of the original message. \
 * *Example:* A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ReplyKeyboardMarkup @JsonCreator constructor(
    @JsonProperty("keyboard")
    val keyboard: Array<Array<KeyboardButton>>,
    @JsonProperty("resize_keyboard")
    val resizeKeyboard: Boolean?,
    @JsonProperty("one_time_keyboard")
    val oneTimeKeyboard: Boolean?,
    @JsonProperty("selective")
    val selective: Boolean?
) : ReplyMarkup {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReplyKeyboardMarkup

        if (!keyboard.contentDeepEquals(other.keyboard)) return false
        if (resizeKeyboard != other.resizeKeyboard) return false
        if (oneTimeKeyboard != other.oneTimeKeyboard) return false
        if (selective != other.selective) return false

        return true
    }

    override fun hashCode(): Int {
        var result = keyboard.contentDeepHashCode()
        result = 31 * result + (resizeKeyboard?.hashCode() ?: 0)
        result = 31 * result + (oneTimeKeyboard?.hashCode() ?: 0)
        result = 31 * result + (selective?.hashCode() ?: 0)
        return result
    }
}