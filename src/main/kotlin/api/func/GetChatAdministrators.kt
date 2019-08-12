@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.ChatMember

/**
 * Use this method to get a list of administrators in a chat. On success, returns an Array of [ChatMember][ChatMember] objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChatAdministrators(
    chatId: String
): Future<List<ChatMember>?> =
    sendRequest<List<ChatMember>?>("getChatAdministrators", listOf(Pair("chat_id", chatId)))

fun ApiContext.getChatAdministrators(
    chatId: String,
    callback: (result: List<ChatMember>?) -> Unit
): ApiContext =
    sendRequestCallback<List<ChatMember>?>("getChatAdministrators", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.getChatAdministratorsAwait(
    chatId: String
): List<ChatMember>? = sendRequestAwait<List<ChatMember>?>("getChatAdministrators", listOf(Pair("chat_id", chatId)))