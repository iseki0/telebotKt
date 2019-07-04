package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about an incoming pre-checkout query.
 * **Telegram Passport** is a unified authorization method for services that require personal identification. Users can upload their documents once, then instantly share their data with services that require real-world ID (finance, ICOs, etc.). Please see the [manual](https://core.telegram.org/passport) for details.
 *
 * @param[id] Unique query identifier
 * @param[from] types.User who sent the query
 * @param[currency] Three-letter ISO 4217 [currency](https://core.telegram.org/bots/payments#supported-currencies) code
 * @param[totalAmount] Total price in the *smallest units* of the currency (integer, **not** float/double). For example, for a price of  `US$ 1.45`  pass  `amount = 145` . See the *exp* parameter in [currencies.json](https://core.telegram.org/bots/payments/currencies.json), it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @param[invoicePayload] Bot specified invoice payload
 * @param[shippingOptionId] *Optional*. Identifier of the shipping option chosen by the user
 * @param[orderInfo] *Optional*. Order info provided by the user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PreCheckoutQuery @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("from")
    val from: User,
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("total_amount")
    val totalAmount: Int,
    @JsonProperty("invoice_payload")
    val invoicePayload: String,
    @JsonProperty("shipping_option_id")
    val shippingOptionId: String?,
    @JsonProperty("order_info")
    val orderInfo: OrderInfo?
)