@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputMedia
import api.MediaGroupable
import api.ParseMode
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a photo to be sent.
 *
 * @param[type] Type of the result, must be *photo*
 * @param[media] File to send. Pass a file_id to send a file that exists on the Telegram servers (recommended), pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://&lt;file_attach_name&gt;” to upload a new one using multipart/form-data under &lt;file_attach_name&gt; name. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[caption] *Optional*. Caption of the photo to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputMediaPhoto @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("media")
    @JsonProperty("media")
    val media: String,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null
) : InputMedia, MediaGroupable