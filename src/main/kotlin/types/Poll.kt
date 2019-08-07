package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about a poll.
 *
 * @param[id] Unique poll identifier
 * @param[question] types.Poll question, 1-255 characters
 * @param[options] List of poll options
 * @param[isClosed] True, if the poll is closed
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Poll @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("question")
    val question: String,
    @JsonProperty("options")
    val options: Array<PollOption>,
    @get:JsonProperty("is_closed")
    @JsonProperty("is_closed")
    val isClosed: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Poll

        if (id != other.id) return false
        if (question != other.question) return false
        if (!options.contentEquals(other.options)) return false
        if (isClosed != other.isClosed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + question.hashCode()
        result = 31 * result + options.contentHashCode()
        result = 31 * result + isClosed.hashCode()
        return result
    }
}