@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to delete a sticker from a set created by the bot. Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 */
fun ApiContext.deleteStickerFromSet(
    sticker: String
): Future<Boolean?> =
    sendRequest<Boolean?>("deleteStickerFromSet", listOf(Pair("sticker", sticker)), object : TypeReference<Boolean> {})

fun ApiContext.deleteStickerFromSet(
    sticker: String,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "deleteStickerFromSet",
    listOf(Pair("sticker", sticker)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.deleteStickerFromSetAwait(
    sticker: String
): Boolean? = sendRequestAwait<Boolean?>(
    "deleteStickerFromSet",
    listOf(Pair("sticker", sticker)),
    object : TypeReference<Boolean> {})