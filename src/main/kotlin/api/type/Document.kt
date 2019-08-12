@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a general file (as opposed to [photos][PhotoSize], [voice messages][Voice] and [audio files][Audio]).
 *
 * @param[fileId] Identifier for this file
 * @param[thumb] *Optional*. Document thumbnail as defined by sender
 * @param[fileName] *Optional*. Original filename as defined by sender
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Document @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null,
    @get:JsonProperty("file_name")
    @JsonProperty("file_name")
    val fileName: String? = null,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)