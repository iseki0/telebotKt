@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Chat

/**
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a [Chat][Chat] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChat(
    chatId: String
): Future<Chat?> = sendRequest<Chat?>("getChat", listOf(Pair("chat_id", chatId)))

fun ApiContext.getChat(
    chatId: String,
    callback: (result: Chat?) -> Unit
): ApiContext = sendRequestCallback<Chat?>("getChat", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.getChatAwait(
    chatId: String
): Chat? = sendRequestAwait<Chat?>("getChat", listOf(Pair("chat_id", chatId)))