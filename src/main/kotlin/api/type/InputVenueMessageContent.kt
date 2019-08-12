@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content](https://core.telegram.org#inputmessagecontent) of a venue message to be sent as the result of an inline query.
 *
 * @param[latitude] Latitude of the venue in degrees
 * @param[longitude] Longitude of the venue in degrees
 * @param[title] Name of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] *Optional*. Foursquare identifier of the venue, if known
 * @param[foursquareType] *Optional*. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputVenueMessageContent @JsonCreator constructor(
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
    val foursquareType: String? = null
) : InputMessageContent