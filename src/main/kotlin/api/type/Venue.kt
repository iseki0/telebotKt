@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a venue.
 *
 * @param[location] Venue location
 * @param[title] Name of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] *Optional*. Foursquare identifier of the venue
 * @param[foursquareType] *Optional*. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Venue @JsonCreator constructor(
    @get:JsonProperty("location")
    @JsonProperty("location")
    val location: Location,
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
)