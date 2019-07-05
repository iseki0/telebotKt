package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content][InputMessageContent] of a location message to be sent as the result of an inline query.
 *
 * @param[latitude] Latitude of the location in degrees
 * @param[longitude] Longitude of the location in degrees
 * @param[livePeriod] *Optional*. Period in seconds for which the location can be updated, should be between 60 and 86400.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputLocationMessageContent @JsonCreator constructor(
    @JsonProperty("latitude")
    val latitude: Float,
    @JsonProperty("longitude")
    val longitude: Float,
    @JsonProperty("live_period")
    val livePeriod: Int?
) : InputMessageContent