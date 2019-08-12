@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputFile
import api.InputMedia
import api.ParseMode
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an audio file to be treated as music to be sent.
 *
 * @param[type] Type of the result, must be *audio*
 * @param[media] File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[thumb] *Optional*. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[caption] *Optional*. Caption of the audio to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[duration] *Optional*. Duration of the audio in seconds
 * @param[performer] *Optional*. Performer of the audio
 * @param[title] *Optional*. Title of the audio
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputMediaAudio @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("media")
    @JsonProperty("media")
    val media: String,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: InputFile? = null,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @get:JsonProperty("duration")
    @JsonProperty("duration")
    val duration: Int? = null,
    @get:JsonProperty("performer")
    @JsonProperty("performer")
    val performer: String? = null,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String? = null
) : InputMedia