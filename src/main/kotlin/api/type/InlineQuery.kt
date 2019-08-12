@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot could return some default or trending results.
 *
 * @param[id] Unique identifier for this query
 * @param[from] Sender
 * @param[location] *Optional*. Sender location, only for bots that request user location
 * @param[query] Text of the query (up to 512 characters)
 * @param[offset] Offset of the results to be returned, can be controlled by the bot
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQuery @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("from")
    @JsonProperty("from")
    val from: User,
    @get:JsonProperty("location")
    @JsonProperty("location")
    val location: Location? = null,
    @get:JsonProperty("query")
    @JsonProperty("query")
    val query: String,
    @get:JsonProperty("offset")
    @JsonProperty("offset")
    val offset: String
)