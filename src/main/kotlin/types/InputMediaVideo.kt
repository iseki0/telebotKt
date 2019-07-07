package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a video to be sent.
 *
 * @param[type] Type of the result, must be *video*
 * @param[media] types.File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>” to upload a new one using multipart/form-data under <file_attach_name> name. [More info on Sending Files »][Sending files]
 * @param[thumb] *Optional*. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[caption] *Optional*. Caption of the video to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[width] *Optional*. types.Video width
 * @param[height] *Optional*. types.Video height
 * @param[duration] *Optional*. types.Video duration
 * @param[supportsStreaming] *Optional*. Pass *True*, if the uploaded video is suitable for streaming
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputMediaVideo @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("media")
    val media: String,
    @JsonProperty("thumb")
    val thumb: String? = null,
    @JsonProperty("caption")
    val caption: String? = null,
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @JsonProperty("width")
    val width: Int? = null,
    @JsonProperty("height")
    val height: Int? = null,
    @JsonProperty("duration")
    val duration: Int? = null,
    @JsonProperty("supports_streaming")
    val supportsStreaming: Boolean? = null
) : InputMedia, MediaGroupable