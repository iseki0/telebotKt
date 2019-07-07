package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one shipping option.
 *
 * @param[id] Shipping option identifier
 * @param[title] Option title
 * @param[prices] List of price portions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ShippingOption @JsonCreator constructor(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("title")
    val title: String? = null,
    @JsonProperty("prices")
    val prices: Array<LabeledPrice>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ShippingOption

        if (id != other.id) return false
        if (title != other.title) return false
        if (!prices.contentEquals(other.prices)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + prices.contentHashCode()
        return result
    }
}