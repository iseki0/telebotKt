@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one row of the high scores table for a game.
 *
 * @param[position] Position in high score table for the game
 * @param[user] User
 * @param[score] Score
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GameHighScore @JsonCreator constructor(
    @get:JsonProperty("position")
    @JsonProperty("position")
    val position: Int,
    @get:JsonProperty("user")
    @JsonProperty("user")
    val user: User,
    @get:JsonProperty("score")
    @JsonProperty("score")
    val score: Int
)