package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a general file (as opposed to [photos][PhotoSize], [voice messages][Voice] and [audio files][Audio]).
 *
 * @param[fileId] Unique file identifier
 * @param[thumb] *Optional*. types.Document thumbnail as defined by sender
 * @param[fileName] *Optional*. Original filename as defined by sender
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. types.File size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Document @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("thumb")
    val thumb: PhotoSize?,
    @JsonProperty("file_name")
    val fileName: String?,
    @JsonProperty("mime_type")
    val mimeType: String?,
    @JsonProperty("file_size")
    val fileSize: Int?
)