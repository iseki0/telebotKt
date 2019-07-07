package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one size of a photo or a [file][Document] / [sticker][Sticker] thumbnail.
 *
 * @param[fileId] Unique identifier for this file
 * @param[width] Photo width
 * @param[height] Photo height
 * @param[fileSize] *Optional*. types.File size
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PhotoSize @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("width")
    val width: Int,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("file_size")
    val fileSize: Int? = null
)