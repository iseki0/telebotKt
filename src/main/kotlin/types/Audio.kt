package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 *
 * @param[fileId] Unique identifier for this file
 * @param[duration] Duration of the audio in seconds as defined by sender
 * @param[performer] *Optional*. Performer of the audio as defined by sender or by audio tags
 * @param[title] *Optional*. Title of the audio as defined by sender or by audio tags
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. types.File size
 * @param[thumb] *Optional*. Thumbnail of the album cover to which the music file belongs
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Audio @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("duration")
    val duration: Int,
    @JsonProperty("performer")
    val performer: String?,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("mime_type")
    val mimeType: String?,
    @JsonProperty("file_size")
    val fileSize: Int?,
    @JsonProperty("thumb")
    val thumb: PhotoSize?
)