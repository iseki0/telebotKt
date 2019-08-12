@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represent a user's profile pictures.
 *
 * @param[totalCount] Total number of profile pictures the target user has
 * @param[photos] Requested profile pictures (in up to 4 sizes each)
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserProfilePhotos @JsonCreator constructor(
    @get:JsonProperty("total_count")
    @JsonProperty("total_count")
    val totalCount: Int,
    @get:JsonProperty("photos")
    @JsonProperty("photos")
    val photos: List<List<PhotoSize>>
)