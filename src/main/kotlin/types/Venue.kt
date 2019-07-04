package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a venue.
 *
 * @param[location] types.Venue location
 * @param[title] Name of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] *Optional*. Foursquare identifier of the venue
 * @param[foursquareType] *Optional*. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Venue @JsonCreator constructor(
    @JsonProperty("location")
    val location: Location,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("address")
    val address: String,
    @JsonProperty("foursquare_id")
    val foursquareId: String?,
    @JsonProperty("foursquare_type")
    val foursquareType: String?
)