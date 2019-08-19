@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about a poll.
 *
 * @param[id] Unique poll identifier
 * @param[question] Poll question, 1-255 characters
 * @param[options] List of poll options
 * @param[isClosed] True, if the poll is closed
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Poll @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("question")
    @JsonProperty("question")
    val question: String,
    @get:JsonProperty("options")
    @JsonProperty("options")
    val options: List<PollOption>,
    @get:JsonProperty("is_closed")
    @JsonProperty("is_closed")
    val isClosed: Boolean
) : UpdateMsg