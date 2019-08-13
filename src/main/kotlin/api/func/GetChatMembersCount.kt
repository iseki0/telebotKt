@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.ApiContext
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.Future

/**
 * Use this method to get the number of members in a chat. Returns *Int* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChatMembersCount(
    chatId: String
): Future<Int?> = sendRequest<Int?>("getChatMembersCount", listOf(Pair("chat_id", chatId)))

fun ApiContext.getChatMembersCount(
    chatId: String,
    callback: (result: Int?) -> Unit
): ApiContext = sendRequestCallback<Int?>("getChatMembersCount", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.getChatMembersCountAwait(
    chatId: String
): Int? = sendRequestAwait<Int?>("getChatMembersCount", listOf(Pair("chat_id", chatId)))