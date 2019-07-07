package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents information about an order.
 *
 * @param[name] *Optional*. types.User name
 * @param[phoneNumber] *Optional*. types.User's phone number
 * @param[email] *Optional*. types.User email
 * @param[shippingAddress] *Optional*. types.User shipping address
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderInfo @JsonCreator constructor(
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("phone_number")
    val phoneNumber: String? = null,
    @JsonProperty("email")
    val email: String? = null,
    @JsonProperty("shipping_address")
    val shippingAddress: ShippingAddress? = null
)