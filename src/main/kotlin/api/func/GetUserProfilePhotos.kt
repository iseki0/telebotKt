@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.UserProfilePhotos

/**
 * Use this method to get a list of profile pictures for a user. Returns a [UserProfilePhotos][UserProfilePhotos] object.
 *
 * @param[userId] Unique identifier of the target user
 * @param[offset] Sequential number of the first photo to be returned. By default, all photos are returned.
 * @param[limit] Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
 */
fun ApiContext.getUserProfilePhotos(
    userId: Int,
    offset: Int? = null,
    limit: Int? = null
): Future<UserProfilePhotos?> = sendRequest<UserProfilePhotos?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit))
)

fun ApiContext.getUserProfilePhotos(
    userId: Int,
    offset: Int? = null,
    limit: Int? = null,
    callback: (result: UserProfilePhotos?) -> Unit
): ApiContext = sendRequestCallback<UserProfilePhotos?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit)),
    callback
)

suspend fun ApiContext.getUserProfilePhotosAwait(
    userId: Int,
    offset: Int? = null,
    limit: Int? = null
): UserProfilePhotos? = sendRequestAwait<UserProfilePhotos?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit))
)