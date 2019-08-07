package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a video file.
 *
 * @param[fileId] Unique identifier for this file
 * @param[width] types.Video width as defined by sender
 * @param[height] types.Video height as defined by sender
 * @param[duration] Duration of the video in seconds as defined by sender
 * @param[thumb] *Optional*. types.Video thumbnail
 * @param[mimeType] *Optional*. Mime type of a file as defined by sender
 * @param[fileSize] *Optional*. types.File size
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Video @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: FileId,
    @JsonProperty("width")
    val width: Int,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("duration")
    val duration: Int,
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null,
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @JsonProperty("file_size")
    val fileSize: Int? = null
)