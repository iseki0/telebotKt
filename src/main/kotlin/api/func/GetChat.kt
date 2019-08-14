@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Chat
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a [Chat][Chat] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChat(
    chatId: String
): Future<GetChatResult?> = sendRequest<GetChatResult?>("getChat", listOf(Pair("chat_id", chatId)))

fun ApiContext.getChat(
    chatId: String,
    callback: (result: AsyncResult<GetChatResult?>) -> Unit
): ApiContext = sendRequestCallback<GetChatResult?>("getChat", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.getChatAwait(
    chatId: String
): GetChatResult? = sendRequestAwait<GetChatResult?>("getChat", listOf(Pair("chat_id", chatId)))