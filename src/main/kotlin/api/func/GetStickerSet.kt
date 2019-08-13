@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to get a sticker set. On success, a [StickerSet][StickerSet] object is returned.
 *
 * @param[name] Name of the sticker set
 */
fun ApiContext.getStickerSet(
    name: String
): Future<StickerSet?> =
    sendRequest<StickerSet?>("getStickerSet", listOf(Pair("name", name)), object : TypeReference<StickerSet> {})

fun ApiContext.getStickerSet(
    name: String,
    callback: (result: AsyncResult<StickerSet?>) -> Unit
): ApiContext = sendRequestCallback<StickerSet?>(
    "getStickerSet",
    listOf(Pair("name", name)),
    callback,
    object : TypeReference<StickerSet> {})

suspend fun ApiContext.getStickerSetAwait(
    name: String
): StickerSet? =
    sendRequestAwait<StickerSet?>("getStickerSet", listOf(Pair("name", name)), object : TypeReference<StickerSet> {})