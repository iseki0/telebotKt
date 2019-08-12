@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a link to an article or web page.
 *
 * @param[type] Type of the result, must be *article*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[title] Title of the result
 * @param[inputMessageContent] Content of the message to be sent
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[url] *Optional*. URL of the result
 * @param[hideUrl] *Optional*. Pass *True*, if you don't want the URL to be shown in the message
 * @param[description] *Optional*. Short description of the result
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultArticle @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("url")
    @JsonProperty("url")
    val url: String? = null,
    @get:JsonProperty("hide_url")
    @JsonProperty("hide_url")
    val hideUrl: Boolean? = null,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String? = null,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String? = null,
    @get:JsonProperty("thumb_width")
    @JsonProperty("thumb_width")
    val thumbWidth: Int? = null,
    @get:JsonProperty("thumb_height")
    @JsonProperty("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult