package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a chat photo.
 *
 * @param[smallFileId] Unique file identifier of small (160x160) chat photo. This file_id can be used only for photo download.
 * @param[bigFileId] Unique file identifier of big (640x640) chat photo. This file_id can be used only for photo download.
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChatPhoto @JsonCreator constructor(
    @JsonProperty("small_file_id")
    val smallFileId: FileId,
    @JsonProperty("big_file_id")
    val bigFileId: FileId
)