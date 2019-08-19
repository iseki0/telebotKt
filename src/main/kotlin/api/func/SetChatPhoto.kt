@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * >  Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[photo] New chat photo, uploaded using multipart/form-data
 */
fun ApiContext.setChatPhoto(
    chatId: String,
    photo: InputFile
): Future<SetChatPhotoResult?> =
    sendRequest<SetChatPhotoResult?>("setChatPhoto", listOf(Pair("chat_id", chatId), Pair("photo", photo)))

fun ApiContext.setChatPhoto(
    chatId: String,
    photo: InputFile,
    callback: (result: AsyncResult<SetChatPhotoResult?>) -> Unit
): ApiContext = sendRequestCallback<SetChatPhotoResult?>(
    "setChatPhoto",
    listOf(Pair("chat_id", chatId), Pair("photo", photo)),
    callback
)

suspend fun ApiContext.setChatPhotoAwait(
    chatId: String,
    photo: InputFile
): SetChatPhotoResult? =
    sendRequestAwait<SetChatPhotoResult?>("setChatPhoto", listOf(Pair("chat_id", chatId), Pair("photo", photo)))