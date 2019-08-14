@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.ChatMember
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to get information about a member of a chat. Returns a [ChatMember][ChatMember] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 * @param[userId] Unique identifier of the target user
 */
fun ApiContext.getChatMember(
    chatId: String,
    userId: Int
): Future<GetChatMemberResult?> =
    sendRequest<GetChatMemberResult?>("getChatMember", listOf(Pair("chat_id", chatId), Pair("user_id", userId)))

fun ApiContext.getChatMember(
    chatId: String,
    userId: Int,
    callback: (result: AsyncResult<GetChatMemberResult?>) -> Unit
): ApiContext = sendRequestCallback<GetChatMemberResult?>(
    "getChatMember",
    listOf(Pair("chat_id", chatId), Pair("user_id", userId)),
    callback
)

suspend fun ApiContext.getChatMemberAwait(
    chatId: String,
    userId: Int
): GetChatMemberResult? =
    sendRequestAwait<GetChatMemberResult?>("getChatMember", listOf(Pair("chat_id", chatId), Pair("user_id", userId)))