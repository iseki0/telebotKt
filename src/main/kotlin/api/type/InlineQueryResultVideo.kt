@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the video.
 * >  If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you **must** replace its content using *input_message_content*.
 *
 * @param[type] Type of the result, must be *video*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[videoUrl] A valid URL for the embedded video player or video file
 * @param[mimeType] Mime type of the content of video url, “text/html” or “video/mp4”
 * @param[thumbUrl] URL of the thumbnail (jpeg only) for the video
 * @param[title] Title for the result
 * @param[caption] *Optional*. Caption of the video to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[videoWidth] *Optional*. Video width
 * @param[videoHeight] *Optional*. Video height
 * @param[videoDuration] *Optional*. Video duration in seconds
 * @param[description] *Optional*. Short description of the result
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the video. This field is **required** if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultVideo @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("video_url")
    @JsonProperty("video_url")
    val videoUrl: String,
    @get:JsonProperty("mime_type")
    @JsonProperty("mime_type")
    val mimeType: String,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("parse_mode")
    @JsonProperty("parse_mode")
    val parseMode: String? = null,
    @get:JsonProperty("video_width")
    @JsonProperty("video_width")
    val videoWidth: Int? = null,
    @get:JsonProperty("video_height")
    @JsonProperty("video_height")
    val videoHeight: Int? = null,
    @get:JsonProperty("video_duration")
    @JsonProperty("video_duration")
    val videoDuration: Int? = null,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult