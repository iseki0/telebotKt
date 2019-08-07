package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a voice note.
 *
 * @param[fileId] Unique identifier for this file
 * @param[duration] Duration of the audio in seconds as defined by sender
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. types.File size
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Voice @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("duration")
    val duration: Int,
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @JsonProperty("file_size")
    val fileSize: Int? = null
)