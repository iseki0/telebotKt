@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.File
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a [File][File] object is returned. The file can then be downloaded via the link `https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;`, where `&lt;file_path&gt;` is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling [getFile][getFile] again.
 *
 * @param[fileId] File identifier to get info about
 */
fun ApiContext.getFile(
    fileId: String
): Future<GetFileResult?> = sendRequest<GetFileResult?>("getFile", listOf(Pair("file_id", fileId)))

fun ApiContext.getFile(
    fileId: String,
    callback: (result: AsyncResult<GetFileResult?>) -> Unit
): ApiContext = sendRequestCallback<GetFileResult?>("getFile", listOf(Pair("file_id", fileId)), callback)

suspend fun ApiContext.getFileAwait(
    fileId: String
): GetFileResult? = sendRequestAwait<GetFileResult?>("getFile", listOf(Pair("file_id", fileId)))