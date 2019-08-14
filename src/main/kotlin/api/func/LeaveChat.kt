@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.leaveChat(
    chatId: String
): Future<LeaveChatResult?> = sendRequest<LeaveChatResult?>("leaveChat", listOf(Pair("chat_id", chatId)))

fun ApiContext.leaveChat(
    chatId: String,
    callback: (result: AsyncResult<LeaveChatResult?>) -> Unit
): ApiContext = sendRequestCallback<LeaveChatResult?>("leaveChat", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.leaveChatAwait(
    chatId: String
): LeaveChatResult? = sendRequestAwait<LeaveChatResult?>("leaveChat", listOf(Pair("chat_id", chatId)))