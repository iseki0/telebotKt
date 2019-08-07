package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a point on the map.
 *
 * @param[longitude] Longitude as defined by sender
 * @param[latitude] Latitude as defined by sender
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Location @JsonCreator constructor(
    @JsonProperty("longitude")
    val longitude: Float,
    @JsonProperty("latitude")
    val latitude: Float
)