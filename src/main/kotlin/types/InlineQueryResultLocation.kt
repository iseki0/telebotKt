package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a location on a map. By default, the location will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the location.
 * **Note:** This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.
 *
 * @param[type] Type of the result, must be *location*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[latitude] types.Location latitude in degrees
 * @param[longitude] types.Location longitude in degrees
 * @param[title] types.Location title
 * @param[livePeriod] *Optional*. Period in seconds for which the location can be updated, should be between 60 and 86400.
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the location
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultLocation @JsonCreator constructor(
    @JsonProperty("type")
    @ValueMustBe("location")
    val type: String = "location",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("latitude")
    val latitude: Double,
    @JsonProperty("longitude")
    val longitude: Double,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("live_period")
    val livePeriod: Int?,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup?,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent?,
    @JsonProperty("thumb_url")
    val thumbUrl: String?,
    @JsonProperty("thumb_width")
    val thumbWidth: Int?,
    @JsonProperty("thumb_height")
    val thumbHeight: Int?
) : InlineQueryResult