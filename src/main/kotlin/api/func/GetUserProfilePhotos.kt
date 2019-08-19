@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.GetUserProfilePhotosResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.UserProfilePhotos
import io.vertx.core.AsyncResult
import io.vertx.core.Future

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
): Future<GetUserProfilePhotosResult?> = sendRequest<GetUserProfilePhotosResult?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit))
)

fun ApiContext.getUserProfilePhotos(
    userId: Int,
    offset: Int? = null,
    limit: Int? = null,
    callback: (result: AsyncResult<GetUserProfilePhotosResult?>) -> Unit
): ApiContext = sendRequestCallback<GetUserProfilePhotosResult?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit)),
    callback
)

suspend fun ApiContext.getUserProfilePhotosAwait(
    userId: Int,
    offset: Int? = null,
    limit: Int? = null
): GetUserProfilePhotosResult? = sendRequestAwait<GetUserProfilePhotosResult?>(
    "getUserProfilePhotos",
    listOf(Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit))
)