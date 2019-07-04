package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue in an unspecified place. The error is considered resolved when new data is added.
 * Your bot can offer users **HTML5 games** to play solo or to compete against each other in groups and one-on-one chats. Create games via [@BotFather](https://tme/botfather) using the * /newgame* command. Please note that this kind of power requires responsibility: you will need to accept the terms for each game that your bots will be offering.
 *
 * @param[source] Error source, must be *unspecified*
 * @param[type] Type of element of the user's Telegram Passport which has the issue
 * @param[elementHash] Base64-encoded element hash
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorUnspecified @JsonCreator constructor(
    @JsonProperty("source")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("element_hash")
    val elementHash: String,
    @JsonProperty("message")
    val message: String
)