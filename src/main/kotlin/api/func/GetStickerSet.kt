@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.GetStickerSetResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.StickerSet
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to get a sticker set. On success, a [StickerSet][StickerSet] object is returned.
 *
 * @param[name] Name of the sticker set
 */
fun ApiContext.getStickerSet(
    name: String
): Future<GetStickerSetResult> = sendRequest<GetStickerSetResult>("getStickerSet", listOf(Pair("name", name)))

fun ApiContext.getStickerSet(
    name: String,
    callback: (result: AsyncResult<GetStickerSetResult>) -> Unit
): ApiContext = sendRequestCallback<GetStickerSetResult>("getStickerSet", listOf(Pair("name", name)), callback)

suspend fun ApiContext.getStickerSetAwait(
    name: String
): GetStickerSetResult = sendRequestAwait<GetStickerSetResult>("getStickerSet", listOf(Pair("name", name)))