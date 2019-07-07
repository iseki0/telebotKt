package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultArticle @JsonCreator constructor(
    @ValueMustBe("article")
    @JsonProperty("type")
    val type: String = "article",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @JsonProperty("url")
    val url: String? = null,
    @JsonProperty("hide_url")
    val hideUrl: Boolean? = null,
    @JsonProperty("description")
    val description: String? = null,
    @JsonProperty("thumb_url")
    val thumbUrl: String? = null,
    @JsonProperty("thumb_width")
    val thumbWidth: Int? = null,
    @JsonProperty("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult