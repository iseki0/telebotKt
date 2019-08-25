@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import api.type.File
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to upload a .png file with a sticker for later use in *createNewStickerSet* and *addStickerToSet* methods (can be used multiple times). Returns the uploaded [File][File] on success.
 *
 * @param[userId] User identifier of sticker file owner
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. [More info on Sending Files »](https://core.telegram.org#sending-files)
 */
fun ApiContext.uploadStickerFile(
    userId: Int,
    pngSticker: InputFile
): Future<UploadStickerFileResult> = sendRequest<UploadStickerFileResult>(
    "uploadStickerFile",
    listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker))
)

fun ApiContext.uploadStickerFile(
    userId: Int,
    pngSticker: InputFile,
    callback: (result: AsyncResult<UploadStickerFileResult>) -> Unit
): ApiContext = sendRequestCallback<UploadStickerFileResult>(
    "uploadStickerFile",
    listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker)),
    callback
)

suspend fun ApiContext.uploadStickerFileAwait(
    userId: Int,
    pngSticker: InputFile
): UploadStickerFileResult = sendRequestAwait<UploadStickerFileResult>(
    "uploadStickerFile",
    listOf(Pair("user_id", userId), Pair("png_sticker", pngSticker))
)