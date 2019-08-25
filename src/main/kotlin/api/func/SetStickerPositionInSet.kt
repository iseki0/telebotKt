@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.SetStickerPositionInSetResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 * @param[position] New sticker position in the set, zero-based
 */
fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int
): Future<SetStickerPositionInSetResult> = sendRequest<SetStickerPositionInSetResult>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position))
)

fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int,
    callback: (result: AsyncResult<SetStickerPositionInSetResult>) -> Unit
): ApiContext = sendRequestCallback<SetStickerPositionInSetResult>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position)),
    callback
)

suspend fun ApiContext.setStickerPositionInSetAwait(
    sticker: String,
    position: Int
): SetStickerPositionInSetResult = sendRequestAwait<SetStickerPositionInSetResult>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position))
)