@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a portion of the price for goods or services.
 *
 * @param[label] Portion label
 * @param[amount] Price of the product in the *smallest units* of the [currency](https://core.telegram.org/bots/payments#supported-currencies) (integer, **not** float/double). For example, for a price of `US$ 1.45` pass `amount = 145`. See the *exp* parameter in [currencies.json](https://core.telegram.org/bots/payments/currencies.json), it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class LabeledPrice @JsonCreator constructor(
    @get:JsonProperty("label")
    @JsonProperty("label")
    val label: String,
    @get:JsonProperty("amount")
    @JsonProperty("amount")
    val amount: Int
)