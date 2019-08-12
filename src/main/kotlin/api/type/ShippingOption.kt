@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one shipping option.
 *
 * @param[id] Shipping option identifier
 * @param[title] Option title
 * @param[prices] List of price portions
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingOption @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("prices")
    @JsonProperty("prices")
    val prices: List<LabeledPrice>
)