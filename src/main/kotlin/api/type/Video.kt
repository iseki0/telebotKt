@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a video file.
 *
 * @param[fileId] Identifier for this file
 * @param[width] Video width as defined by sender
 * @param[height] Video height as defined by sender
 * @param[duration] Duration of the video in seconds as defined by sender
 * @param[thumb] *Optional*. Video thumbnail
 * @param[mimeType] *Optional*. Mime type of a file as defined by sender
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Video @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("width")
    @JsonProperty("width")
    val width: Int,
    @get:JsonProperty("height")
    @JsonProperty("height")
    val height: Int,
    @get:JsonProperty("duration")
    @JsonProperty("duration")
    val duration: Int,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)