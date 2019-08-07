package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a link to a page containing an embedded video player or a video file. By default, this video file will be sent by the user with an optional caption. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the video.
 * If an types.InlineQueryResultVideo message contains an embedded video (e.g., YouTube), you **must** replace its content using *input_message_content*.
 *
 * @param[type] Type of the result, must be *video*
 * @param[id] Unique identifier for this result, 1-64 bytes
 * @param[videoUrl] A valid URL for the embedded video player or video file
 * @param[mimeType] Mime type of the content of video url, “text/html” or “video/mp4”
 * @param[thumbUrl] URL of the thumbnail (jpeg only) for the video
 * @param[title] Title for the result
 * @param[caption] *Optional*. Caption of the video to be sent, 0-1024 characters
 * @param[parseMode] *Optional*. Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[videoWidth] *Optional*. types.Video width
 * @param[videoHeight] *Optional*. types.Video height
 * @param[videoDuration] *Optional*. types.Video duration in seconds
 * @param[description] *Optional*. Short description of the result
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the video. This field is **required** if types.InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultVideo @JsonCreator constructor(
    @JsonProperty("type")
    @ValueMustBe("video")
    val type: String = "video",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("video_url")
    val videoUrl: String,
    @JsonProperty("mime_type")
    val mimeType: String,
    @JsonProperty("thumb_url")
    val thumbUrl: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("caption")
    val caption: String? = null,
    @JsonProperty("parse_mode")
    val parseMode: ParseMode? = null,
    @JsonProperty("video_width")
    val videoWidth: Int? = null,
    @JsonProperty("video_height")
    val videoHeight: Int? = null,
    @JsonProperty("video_duration")
    val videoDuration: Int? = null,
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null
) : InlineQueryResult