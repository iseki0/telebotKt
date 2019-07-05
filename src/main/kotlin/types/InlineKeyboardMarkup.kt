package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) that appears right next to the message it belongs to.
 * **Note:** This will only work in Telegram versions released after 9 April, 2016. Older clients will display *unsupported message*.
 *
 * @param[inlineKeyboard] Array of button rows, each represented by an Array of [types.InlineKeyboardButton][InlineKeyboardButton] objects
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineKeyboardMarkup @JsonCreator constructor(
    @JsonProperty("inline_keyboard")
    val inlineKeyboard: Array<Array<InlineKeyboardButton>>
) : ReplyMarkup {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InlineKeyboardMarkup

        if (!inlineKeyboard.contentDeepEquals(other.inlineKeyboard)) return false

        return true
    }

    override fun hashCode(): Int {
        return inlineKeyboard.contentDeepHashCode()
    }
}