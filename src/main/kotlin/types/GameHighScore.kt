package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one row of the high scores table for a game.
 *
 * @param[position] Position in high score table for the game
 * @param[user] types.User
 * @param[score] Score
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class GameHighScore @JsonCreator constructor(
    @JsonProperty("position")
    val position: Int,
    @JsonProperty("user")
    val user: User,
    @JsonProperty("score")
    val score: Int
)

