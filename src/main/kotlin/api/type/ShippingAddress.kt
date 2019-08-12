@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a shipping address.
 *
 * @param[countryCode] ISO 3166-1 alpha-2 country code
 * @param[state] State, if applicable
 * @param[city] City
 * @param[streetLine1] First line for the address
 * @param[streetLine2] Second line for the address
 * @param[postCode] Address post code
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingAddress @JsonCreator constructor(
    @get:JsonProperty("country_code")
    @JsonProperty("country_code")
    val countryCode: String,
    @get:JsonProperty("state")
    @JsonProperty("state")
    val state: String,
    @get:JsonProperty("city")
    @JsonProperty("city")
    val city: String,
    @get:JsonProperty("street_line1")
    @JsonProperty("street_line1")
    val streetLine1: String,
    @get:JsonProperty("street_line2")
    @JsonProperty("street_line2")
    val streetLine2: String,
    @get:JsonProperty("post_code")
    @JsonProperty("post_code")
    val postCode: String
)