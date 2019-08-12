@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about an incoming shipping query.
 *
 * @param[id] Unique query identifier
 * @param[from] User who sent the query
 * @param[invoicePayload] Bot specified invoice payload
 * @param[shippingAddress] User specified shipping address
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingQuery @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("from")
    @JsonProperty("from")
    val from: User,
    @get:JsonProperty("invoice_payload")
    @JsonProperty("invoice_payload")
    val invoicePayload: String,
    @get:JsonProperty("shipping_address")
    @JsonProperty("shipping_address")
    val shippingAddress: ShippingAddress
)