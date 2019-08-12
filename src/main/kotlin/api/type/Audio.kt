@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 *
 * @param[fileId] Identifier for this file
 * @param[duration] Duration of the audio in seconds as defined by sender
 * @param[performer] *Optional*. Performer of the audio as defined by sender or by audio tags
 * @param[title] *Optional*. Title of the audio as defined by sender or by audio tags
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. File size
 * @param[thumb] *Optional*. Thumbnail of the album cover to which the music file belongs
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Audio @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("duration")
    @JsonProperty("duration")
    val duration: Int,
    @get:JsonProperty("performer")
    @JsonProperty("performer")
    val performer: String? = null,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String? = null,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null
)