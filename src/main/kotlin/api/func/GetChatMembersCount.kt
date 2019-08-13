@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to get the number of members in a chat. Returns *Int* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.getChatMembersCount(
    chatId: String
): Future<Int?> =
    sendRequest<Int?>("getChatMembersCount", listOf(Pair("chat_id", chatId)), object : TypeReference<Int> {})

fun ApiContext.getChatMembersCount(
    chatId: String,
    callback: (result: AsyncResult<Int?>) -> Unit
): ApiContext = sendRequestCallback<Int?>(
    "getChatMembersCount",
    listOf(Pair("chat_id", chatId)),
    callback,
    object : TypeReference<Int> {})

suspend fun ApiContext.getChatMembersCountAwait(
    chatId: String
): Int? = sendRequestAwait<Int?>("getChatMembersCount", listOf(Pair("chat_id", chatId)), object : TypeReference<Int> {})