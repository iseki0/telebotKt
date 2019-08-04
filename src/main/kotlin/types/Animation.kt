package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 *
 * @param[fileId] Unique file identifier
 * @param[width] types.Video width as defined by sender
 * @param[height] types.Video height as defined by sender
 * @param[duration] Duration of the video in seconds as defined by sender
 * @param[thumb] *Optional*. types.Animation thumbnail as defined by sender
 * @param[fileName] *Optional*. Original animation filename as defined by sender
 * @param[mimeType] *Optional*. MIME type of the file as defined by sender
 * @param[fileSize] *Optional*. types.File size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Animation @JsonCreator constructor(
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
    @JsonProperty("file_name")
    val fileName: String? = null,
    @JsonProperty("mime_type")
    val mimeType: String? = null,
    @JsonProperty("file_size")
    val fileSize: Int? = null
)