package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represent a user's profile pictures.
 *
 * @param[totalCount] Total number of profile pictures the target user has
 * @param[photos] Requested profile pictures (in up to 4 sizes each)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserProfilePhotos @JsonCreator constructor(
    @JsonProperty("total_count")
    val totalCount: Int,
    @JsonProperty("photos")
    val photos: Array<Array<PhotoSize>>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserProfilePhotos

        if (totalCount != other.totalCount) return false
        if (!photos.contentDeepEquals(other.photos)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = totalCount
        result = 31 * result + photos.contentDeepHashCode()
        return result
    }
}