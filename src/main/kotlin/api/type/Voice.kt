@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a voice note.
 *
 * @param[fileId] Identifier for this file
 * @param[duration] Duration of the audio in seconds as defined by sender
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Voice @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("duration")
    @JsonProperty("duration")
    val duration: Int,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)