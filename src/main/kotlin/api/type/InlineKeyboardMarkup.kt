@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import api.ReplyMarkup
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) that appears right next to the message it belongs to.
 *
 * @param[inlineKeyboard] Array of button rows, each represented by an Array of [InlineKeyboardButton][InlineKeyboardButton] objects
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineKeyboardMarkup @JsonCreator constructor(
    @get:JsonProperty("inline_keyboard")
    @JsonProperty("inline_keyboard")
    val inlineKeyboard: List<List<InlineKeyboardButton>>
) : ReplyMarkup