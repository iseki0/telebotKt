@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a sticker.
 *
 * @param[fileId] Identifier for this file
 * @param[width] Sticker width
 * @param[height] Sticker height
 * @param[isAnimated] *True*, if the sticker is [animated](https://telegram.org/blog/animated-stickers)
 * @param[thumb] *Optional*. Sticker thumbnail in the .webp or .jpg format
 * @param[emoji] *Optional*. Emoji associated with the sticker
 * @param[setName] *Optional*. Name of the sticker set to which the sticker belongs
 * @param[maskPosition] *Optional*. For mask stickers, the position where the mask should be placed
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Sticker @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("width")
    @JsonProperty("width")
    val width: Int,
    @get:JsonProperty("height")
    @JsonProperty("height")
    val height: Int,
    @get:JsonProperty("is_animated")
    @JsonProperty("is_animated")
    val isAnimated: Boolean,
    @get:JsonProperty("thumb")
    @JsonProperty("thumb")
    val thumb: PhotoSize? = null,
    @get:JsonProperty("emoji")
    @JsonProperty("emoji")
    val emoji: String? = null,
    @get:JsonProperty("set_name")
    @JsonProperty("set_name")
    val setName: String? = null,
    @get:JsonProperty("mask_position")
    @JsonProperty("mask_position")
    val maskPosition: MaskPosition? = null,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)