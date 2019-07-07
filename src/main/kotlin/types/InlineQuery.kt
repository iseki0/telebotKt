package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQuery @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("from")
    val from: User,
    @JsonProperty("location")
    val location: Location? = null,
    @JsonProperty("query")
    val query: String,
    @JsonProperty("offset")
    val offset: String
)