@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one size of a photo or a [file][Document] / [sticker][Sticker] thumbnail.
 *
 * @param[fileId] Identifier for this file
 * @param[width] Photo width
 * @param[height] Photo height
 * @param[fileSize] *Optional*. File size
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PhotoSize @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("width")
    @JsonProperty("width")
    val width: Int,
    @get:JsonProperty("height")
    @JsonProperty("height")
    val height: Int,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null
)