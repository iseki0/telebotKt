package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about an incoming shipping query.
 *
 * @param[id] Unique query identifier
 * @param[from] types.User who sent the query
 * @param[invoicePayload] Bot specified invoice payload
 * @param[shippingAddress] types.User specified shipping address
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingQuery @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("from")
    val from: User,
    @JsonProperty("invoice_payload")
    val invoicePayload: String,
    @JsonProperty("shipping_address")
    val shippingAddress: ShippingAddress
)