@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents information about an order.
 *
 * @param[name] *Optional*. User name
 * @param[phoneNumber] *Optional*. User's phone number
 * @param[email] *Optional*. User email
 * @param[shippingAddress] *Optional*. User shipping address
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OrderInfo @JsonCreator constructor(
    @get:JsonProperty("name")
    @JsonProperty("name")
    val name: String? = null,
    @get:JsonProperty("phone_number")
    @JsonProperty("phone_number")
    val phoneNumber: String? = null,
    @get:JsonProperty("email")
    @JsonProperty("email")
    val email: String? = null,
    @get:JsonProperty("shipping_address")
    @JsonProperty("shipping_address")
    val shippingAddress: ShippingAddress? = null
)