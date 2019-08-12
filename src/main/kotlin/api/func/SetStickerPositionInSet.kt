@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*

/**
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 * @param[position] New sticker position in the set, zero-based
 */
fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int
): Future<Boolean?> =
    sendRequest<Boolean?>("setStickerPositionInSet", listOf(Pair("sticker", sticker), Pair("position", position)))

fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position)),
    callback
)

suspend fun ApiContext.setStickerPositionInSetAwait(
    sticker: String,
    position: Int
): Boolean? =
    sendRequestAwait<Boolean?>("setStickerPositionInSet", listOf(Pair("sticker", sticker), Pair("position", position)))