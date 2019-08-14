@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to delete a sticker from a set created by the bot. Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 */
fun ApiContext.deleteStickerFromSet(
    sticker: String
): Future<DeleteStickerFromSetResult?> =
    sendRequest<DeleteStickerFromSetResult?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)))

fun ApiContext.deleteStickerFromSet(
    sticker: String,
    callback: (result: AsyncResult<DeleteStickerFromSetResult?>) -> Unit
): ApiContext =
    sendRequestCallback<DeleteStickerFromSetResult?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)), callback)

suspend fun ApiContext.deleteStickerFromSetAwait(
    sticker: String
): DeleteStickerFromSetResult? =
    sendRequestAwait<DeleteStickerFromSetResult?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)))