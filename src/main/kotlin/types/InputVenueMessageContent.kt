package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content][InputMessageContent] of a venue message to be sent as the result of an inline query.
 *
 * @param[latitude] Latitude of the venue in degrees
 * @param[longitude] Longitude of the venue in degrees
 * @param[title] Name of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] *Optional*. Foursquare identifier of the venue, if known
 * @param[foursquareType] *Optional*. Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputVenueMessageContent @JsonCreator constructor(
    @JsonProperty("latitude")
    val latitude: Float,
    @JsonProperty("longitude")
    val longitude: Float,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("address")
    val address: String,
    @JsonProperty("foursquare_id")
    val foursquareId: String?,
    @JsonProperty("foursquare_type")
    val foursquareType: String?
)