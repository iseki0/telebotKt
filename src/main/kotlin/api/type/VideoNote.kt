@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a [video message](https://telegram.org/blog/video-messages-and-telescope) (available in Telegram apps as of [v.4.0](https://telegram.org/blog/video-messages-and-telescope)).
 *
 * @param[fileId] Identifier for this file
 * @param[length] Video width and height (diameter of the video message) as defined by sender
 * @param[duration] Duration of the video in seconds as defined by sender
 * @param[thumb] *Optional*. Video thumbnail
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class VideoNote @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("length")
    @JsonProperty("length")
    val length: Int,
    @get:JsonProperty("duration")
    @JsonProperty("duration")
    val duration: Int,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)