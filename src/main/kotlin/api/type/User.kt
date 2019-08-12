@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a Telegram user or bot.
 *
 * @param[id] Unique identifier for this user or bot
 * @param[isBot] True, if this user is a bot
 * @param[firstName] User‘s or bot’s first name
 * @param[lastName] *Optional*. User‘s or bot’s last name
 * @param[username] *Optional*. User‘s or bot’s username
 * @param[languageCode] *Optional*. [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) of the user's language
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class User @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: Int,
    @get:JsonProperty("is_bot")
    @JsonProperty("is_bot")
    val isBot: Boolean,
    @get:JsonProperty("first_name")
    @JsonProperty("first_name")
    val firstName: String,
    @get:JsonProperty("last_name")
    @JsonProperty("last_name")
    val lastName: String? = null,
    @get:JsonProperty("username")
    @JsonProperty("username")
    val username: String? = null,
    @get:JsonProperty("language_code")
    @JsonProperty("language_code")
    val languageCode: String? = null
)