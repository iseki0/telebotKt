@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * >  Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[title] New chat title, 1-255 characters
 */
fun ApiContext.setChatTitle(
    chatId: String,
    title: String
): Future<SetChatTitleResult?> =
    sendRequest<SetChatTitleResult?>("setChatTitle", listOf(Pair("chat_id", chatId), Pair("title", title)))

fun ApiContext.setChatTitle(
    chatId: String,
    title: String,
    callback: (result: AsyncResult<SetChatTitleResult?>) -> Unit
): ApiContext = sendRequestCallback<SetChatTitleResult?>(
    "setChatTitle",
    listOf(Pair("chat_id", chatId), Pair("title", title)),
    callback
)

suspend fun ApiContext.setChatTitleAwait(
    chatId: String,
    title: String
): SetChatTitleResult? =
    sendRequestAwait<SetChatTitleResult?>("setChatTitle", listOf(Pair("chat_id", chatId), Pair("title", title)))