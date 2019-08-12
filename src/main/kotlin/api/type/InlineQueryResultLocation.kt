@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the location.
 *
 * @param[type] Type of the result, must be *location*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[latitude] Location latitude in degrees
 * @param[longitude] Location longitude in degrees
 * @param[title] Location title
 * @param[livePeriod] *Optional*. Period in seconds for which the location can be updated, should be between 60 and 86400.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the location
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultLocation @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("latitude")
    @JsonProperty("latitude")
    val latitude: Double,
    @get:JsonProperty("longitude")
    @JsonProperty("longitude")
    val longitude: Double,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("live_period")
    @JsonProperty("live_period")
    val livePeriod: Int? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
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