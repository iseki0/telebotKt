package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about one answer option in a poll.
 *
 * @param[text] Option text, 1-100 characters
 * @param[voterCount] Number of users that voted for this option
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PollOption @JsonCreator constructor(
    @JsonProperty("text")
    val text: String? = null,
    @JsonProperty("voter_count")
    val voterCount: Int
)