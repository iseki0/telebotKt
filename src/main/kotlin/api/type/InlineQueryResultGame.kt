@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a [Game](https://core.telegram.org#games).
 *
 * @param[type] Type of the result, must be *game*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[gameShortName] Short name of the game
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultGame @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("game_short_name")
    @JsonProperty("game_short_name")
    val gameShortName: String,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null
) : InlineQueryResult