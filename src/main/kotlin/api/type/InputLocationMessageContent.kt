@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content](https://core.telegram.org#inputmessagecontent) of a location message to be sent as the result of an inline query.
 *
 * @param[latitude] Latitude of the location in degrees
 * @param[longitude] Longitude of the location in degrees
 * @param[livePeriod] *Optional*. Period in seconds for which the location can be updated, should be between 60 and 86400.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputLocationMessageContent @JsonCreator constructor(
    @get:JsonProperty("latitude")
    @JsonProperty("latitude")
    val latitude: Float,
    @get:JsonProperty("longitude")
    @JsonProperty("longitude")
    val longitude: Float,
    @get:JsonProperty("live_period")
    @JsonProperty("live_period")
    val livePeriod: Int? = null
) : InputMessageContent