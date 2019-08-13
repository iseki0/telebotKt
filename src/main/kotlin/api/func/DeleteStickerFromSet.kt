@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.ApiContext
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.Future

/**
 * Use this method to delete a sticker from a set created by the bot. Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 */
fun ApiContext.deleteStickerFromSet(
    sticker: String
): Future<Boolean?> = sendRequest<Boolean?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)))

fun ApiContext.deleteStickerFromSet(
    sticker: String,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)), callback)

suspend fun ApiContext.deleteStickerFromSetAwait(
    sticker: String
): Boolean? = sendRequestAwait<Boolean?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)))