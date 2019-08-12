@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.File

/**
 * Use this method to upload a .png file with a sticker for later use in *createNewStickerSet* and *addStickerToSet* methods (can be used multiple times). Returns the uploaded [File][File] on success.
 *
 * @param[userId] User identifier of sticker file owner
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. [More info on Sending Files »](https://core.telegram.org#sending-files)
 */
fun ApiContext.uploadStickerFile(
    userId: Int,
    pngSticker: InputFile
): Future<File?> =
    sendRequest<File?>("uploadStickerFile", listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker)))

fun ApiContext.uploadStickerFile(
    userId: Int,
    pngSticker: InputFile,
    callback: (result: File?) -> Unit
): ApiContext = sendRequestCallback<File?>(
    "uploadStickerFile",
    listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker)),
    callback
)

suspend fun ApiContext.uploadStickerFileAwait(
    userId: Int,
    pngSticker: InputFile
): File? =
    sendRequestAwait<File?>("uploadStickerFile", listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker)))