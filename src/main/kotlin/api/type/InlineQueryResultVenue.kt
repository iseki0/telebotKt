@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a venue. By default, the venue will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the venue.
 *
 * @param[type] Type of the result, must be *venue*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[latitude] Latitude of the venue location in degrees
 * @param[longitude] Longitude of the venue location in degrees
 * @param[title] Title of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] *Optional*. Foursquare identifier of the venue if known
 * @param[foursquareType] *Optional*. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the venue
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultVenue @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("latitude")
    @JsonProperty("latitude")
    val latitude: Float,
    @get:JsonProperty("longitude")
    @JsonProperty("longitude")
    val longitude: Float,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("address")
    @JsonProperty("address")
    val address: String,
    @get:JsonProperty("foursquare_id")
    @JsonProperty("foursquare_id")
    val foursquareId: String? = null,
    @get:JsonProperty("foursquare_type")
    @JsonProperty("foursquare_type")
    val foursquareType: String? = null,
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