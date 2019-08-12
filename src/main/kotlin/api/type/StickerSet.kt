@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a sticker set.
 *
 * @param[name] Sticker set name
 * @param[title] Sticker set title
 * @param[isAnimated] *True*, if the sticker set contains [animated stickers](https://telegram.org/blog/animated-stickers)
 * @param[containsMasks] *True*, if the sticker set contains masks
 * @param[stickers] List of all set stickers
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StickerSet @JsonCreator constructor(
    @get:JsonProperty("name")
    @JsonProperty("name")
    val name: String,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("is_animated")
    @JsonProperty("is_animated")
    val isAnimated: Boolean,
    @get:JsonProperty("contains_masks")
    @JsonProperty("contains_masks")
    val containsMasks: Boolean,
    @get:JsonProperty("stickers")
    @JsonProperty("stickers")
    val stickers: List<Sticker>
)