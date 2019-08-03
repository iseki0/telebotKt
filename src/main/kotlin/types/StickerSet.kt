package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a sticker set.
 *
 * @param[name] types.Sticker set name
 * @param[title] types.Sticker set title
 * @param[isAntimated] *True*, if the sticker set contains [animated stickers](https://telegram.org/blog/animated-stickers)
 * @param[containsMasks] *True*, if the sticker set contains masks
 * @param[stickers] List of all set stickers
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StickerSet @JsonCreator constructor(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("is_animated")
    val isAntimated: Boolean = true,
    @JsonProperty("contains_masks")
    val containsMasks: Boolean,
    @JsonProperty("stickers")
    val stickers: Array<Sticker>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StickerSet

        if (name != other.name) return false
        if (title != other.title) return false
        if (containsMasks != other.containsMasks) return false
        if (!stickers.contentEquals(other.stickers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + containsMasks.hashCode()
        result = 31 * result + stickers.contentHashCode()
        return result
    }
}