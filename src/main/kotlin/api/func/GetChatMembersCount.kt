@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.GetChatMembersCountResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to get the number of members in a chat. Returns *Int* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChatMembersCount(
    chatId: String
): Future<GetChatMembersCountResult> =
    sendRequest<GetChatMembersCountResult>("getChatMembersCount", listOf(Pair("chat_id", chatId)))

fun ApiContext.getChatMembersCount(
    chatId: String,
    callback: (result: AsyncResult<GetChatMembersCountResult>) -> Unit
): ApiContext =
    sendRequestCallback<GetChatMembersCountResult>("getChatMembersCount", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.getChatMembersCountAwait(
    chatId: String
): GetChatMembersCountResult =
    sendRequestAwait<GetChatMembersCountResult>("getChatMembersCount", listOf(Pair("chat_id", chatId)))