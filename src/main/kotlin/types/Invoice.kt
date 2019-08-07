package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains basic information about an invoice.
 *
 * @param[title] Product name
 * @param[description] Product description
 * @param[startParameter] Unique bot deep-linking parameter that can be used to generate this invoice
 * @param[currency] Three-letter ISO 4217 [currency](https://core.telegram.org/bots/payments#supported-currencies) code
 * @param[totalAmount] Total price in the *smallest units* of the currency (integer, **not** float/double). For example, for a price of  `US$ 1.45`  pass  `amount = 145` . See the *exp* parameter in [currencies.json](https://core.telegram.org/bots/payments/currencies.json), it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Invoice @JsonCreator constructor(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("start_parameter")
    val startParameter: String,
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("total_amount")
    val totalAmount: Int
)