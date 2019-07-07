package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a Telegram user or bot.
 *
 * @param[id] Unique identifier for this user or bot
 * @param[isBot] True, if this user is a bot
 * @param[firstName] types.User‘s or bot’s first name
 * @param[lastName] *Optional*. types.User‘s or bot’s last name
 * @param[username] *Optional*. types.User‘s or bot’s username
 * @param[languageCode] *Optional*. [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) of the user's language
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class User @JsonCreator constructor(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("is_bot")
    val isBot: Boolean,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String? = null,
    @JsonProperty("username")
    val username: String? = null,
    @JsonProperty("language_code")
    val languageCode: String? = null
)