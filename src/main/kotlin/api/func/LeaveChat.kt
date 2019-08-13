@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.leaveChat(
    chatId: String
): Future<Boolean?> =
    sendRequest<Boolean?>("leaveChat", listOf(Pair("chat_id", chatId)), object : TypeReference<Boolean> {})

fun ApiContext.leaveChat(
    chatId: String,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "leaveChat",
    listOf(Pair("chat_id", chatId)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.leaveChatAwait(
    chatId: String
): Boolean? =
    sendRequestAwait<Boolean?>("leaveChat", listOf(Pair("chat_id", chatId)), object : TypeReference<Boolean> {})