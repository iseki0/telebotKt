package types

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
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingAddress @JsonCreator constructor(
    @JsonProperty("country_code")
    val countryCode: String,
    @JsonProperty("state")
    val state: String,
    @JsonProperty("city")
    val city: String,
    @JsonProperty("street_line1")
    val streetLine1: String,
    @JsonProperty("street_line2")
    val streetLine2: String,
    @JsonProperty("post_code")
    val postCode: String
)