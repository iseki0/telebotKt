package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a [video message](https://telegram.org/blog/video-messages-and-telescope) (available in Telegram apps as of [v.4.0](https://telegram.org/blog/video-messages-and-telescope)).
 *
 * @param[fileId] Unique identifier for this file
 * @param[length] types.Video width and height (diameter of the video message) as defined by sender
 * @param[duration] Duration of the video in seconds as defined by sender
 * @param[thumb] *Optional*. types.Video thumbnail
 * @param[fileSize] *Optional*. types.File size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class VideoNote @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("length")
    val length: Int,
    @JsonProperty("duration")
    val duration: Int,
    @JsonProperty("thumb")
    val thumb: PhotoSize?,
    @JsonProperty("file_size")
    val fileSize: Int?
)