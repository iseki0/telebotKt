package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a [types.Game][null].
 * **Note:** This will only work in Telegram versions released after October 1, 2016. Older clients will not display any inline results if a game result is among them.
 *
 * @param[type] Type of the result, must be *game*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[gameShortName] Short name of the game
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultGame @JsonCreator constructor(
    @ValueMustBe("game")
    @JsonProperty("type")
    val type: String = "game",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("game_short_name")
    val gameShortName: String,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup?
) : InlineQueryResult