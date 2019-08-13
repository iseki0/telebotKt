@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a [Chat][Chat] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChat(
    chatId: String
): Future<Chat?> = sendRequest<Chat?>("getChat", listOf(Pair("chat_id", chatId)), object : TypeReference<Chat> {})

fun ApiContext.getChat(
    chatId: String,
    callback: (result: AsyncResult<Chat?>) -> Unit
): ApiContext =
    sendRequestCallback<Chat?>("getChat", listOf(Pair("chat_id", chatId)), callback, object : TypeReference<Chat> {})

suspend fun ApiContext.getChatAwait(
    chatId: String
): Chat? = sendRequestAwait<Chat?>("getChat", listOf(Pair("chat_id", chatId)), object : TypeReference<Chat> {})