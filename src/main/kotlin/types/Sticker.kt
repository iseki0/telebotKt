package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a sticker.
 *
 * @param[fileId] Unique identifier for this file
 * @param[width] types.Sticker width
 * @param[height] types.Sticker height
 * @param[thumb] *Optional*. types.Sticker thumbnail in the .webp or .jpg format
 * @param[emoji] *Optional*. Emoji associated with the sticker
 * @param[setName] *Optional*. Name of the sticker set to which the sticker belongs
 * @param[maskPosition] *Optional*. For mask stickers, the position where the mask should be placed
 * @param[fileSize] *Optional*. types.File size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Sticker @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("width")
    val width: Int,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("thumb")
    val thumb: PhotoSize?,
    @JsonProperty("emoji")
    val emoji: String?,
    @JsonProperty("set_name")
    val setName: String?,
    @JsonProperty("mask_position")
    val maskPosition: MaskPosition?,
    @JsonProperty("file_size")
    val fileSize: Int?
)