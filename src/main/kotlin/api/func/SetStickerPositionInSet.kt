@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 * @param[position] New sticker position in the set, zero-based
 */
fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int
): Future<Boolean?> = sendRequest<Boolean?>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position)),
    object : TypeReference<Boolean> {})

fun ApiContext.setStickerPositionInSet(
    sticker: String,
    position: Int,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.setStickerPositionInSetAwait(
    sticker: String,
    position: Int
): Boolean? = sendRequestAwait<Boolean?>(
    "setStickerPositionInSet",
    listOf(Pair("sticker", sticker), Pair("position", position)),
    object : TypeReference<Boolean> {})