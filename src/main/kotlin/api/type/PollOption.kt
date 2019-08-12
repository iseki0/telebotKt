@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about one answer option in a poll.
 *
 * @param[text] Option text, 1-100 characters
 * @param[voterCount] Number of users that voted for this option
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PollOption @JsonCreator constructor(
    @get:JsonProperty("text")
    @JsonProperty("text")
    val text: String,
    @get:JsonProperty("voter_count")
    @JsonProperty("voter_count")
    val voterCount: Int
)