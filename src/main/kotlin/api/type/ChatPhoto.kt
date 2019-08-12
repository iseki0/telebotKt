@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a chat photo.
 *
 * @param[smallFileId] File identifier of small (160x160) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 * @param[bigFileId] File identifier of big (640x640) chat photo. This file_id can be used only for photo download and only for as long as the photo is not changed.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChatPhoto @JsonCreator constructor(
    @get:JsonProperty("small_file_id")
    @JsonProperty("small_file_id")
    val smallFileId: String,
    @get:JsonProperty("big_file_id")
    @JsonProperty("big_file_id")
    val bigFileId: String
)