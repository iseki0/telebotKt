@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * >  Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 */
fun ApiContext.deleteChatPhoto(
    chatId: String
): Future<Boolean?> =
    sendRequest<Boolean?>("deleteChatPhoto", listOf(Pair("chat_id", chatId)), object : TypeReference<Boolean> {})

fun ApiContext.deleteChatPhoto(
    chatId: String,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "deleteChatPhoto",
    listOf(Pair("chat_id", chatId)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.deleteChatPhotoAwait(
    chatId: String
): Boolean? =
    sendRequestAwait<Boolean?>("deleteChatPhoto", listOf(Pair("chat_id", chatId)), object : TypeReference<Boolean> {})