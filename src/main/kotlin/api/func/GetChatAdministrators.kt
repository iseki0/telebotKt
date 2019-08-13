@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to get a list of administrators in a chat. On success, returns an Array of [ChatMember][ChatMember] objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChatAdministrators(
    chatId: String
): Future<Array<ChatMember>?> = sendRequest<Array<ChatMember>?>(
    "getChatAdministrators",
    listOf(Pair("chat_id", chatId)),
    object : TypeReference<Array<ChatMember>> {})

fun ApiContext.getChatAdministrators(
    chatId: String,
    callback: (result: AsyncResult<Array<ChatMember>?>) -> Unit
): ApiContext = sendRequestCallback<Array<ChatMember>?>(
    "getChatAdministrators",
    listOf(Pair("chat_id", chatId)),
    callback,
    object : TypeReference<Array<ChatMember>> {})

suspend fun ApiContext.getChatAdministratorsAwait(
    chatId: String
): Array<ChatMember>? = sendRequestAwait<Array<ChatMember>?>(
    "getChatAdministrators",
    listOf(Pair("chat_id", chatId)),
    object : TypeReference<Array<ChatMember>> {})