@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.MaskPosition
import io.vertx.core.Future


/**
 * Use this method to add a new sticker to a set created by the bot. Returns *True* on success.
 *
 * @param[userId] User identifier of sticker set owner
 * @param[name] Sticker set name
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a *file_id* as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[emojis] One or more emoji corresponding to the sticker
 * @param[maskPosition] A JSON-serialized object for position where the mask should be placed on faces
 */
fun ApiContext.addStickerToSet(
    userId: Int,
    name: String,
    pngSticker: InputFile,
    emojis: String,
    maskPosition: MaskPosition? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "addStickerToSet",
    listOf(
        Pair("user_id", userId),
        Pair("name", name),
        Pair("png_sticker", pngSticker),
        Pair("emojis", emojis),
        Pair("mask_position", maskPosition)
    )
)

fun ApiContext.addStickerToSet(
    userId: Int,
    name: String,
    pngSticker: InputFile,
    emojis: String,
    maskPosition: MaskPosition? = null,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "addStickerToSet",
    listOf(
        Pair("user_id", userId),
        Pair("name", name),
        Pair("png_sticker", pngSticker),
        Pair("emojis", emojis),
        Pair("mask_position", maskPosition)
    ),
    callback
)

suspend fun ApiContext.addStickerToSetAwait(
    userId: Int,
    name: String,
    pngSticker: InputFile,
    emojis: String,
    maskPosition: MaskPosition? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "addStickerToSet",
    listOf(
        Pair("user_id", userId),
        Pair("name", name),
        Pair("png_sticker", pngSticker),
        Pair("emojis", emojis),
        Pair("mask_position", maskPosition)
    )
)