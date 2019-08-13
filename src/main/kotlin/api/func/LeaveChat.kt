@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.ApiContext
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.Future

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format `@channelusername`)
 */
fun ApiContext.leaveChat(
    chatId: String
): Future<Boolean?> = sendRequest<Boolean?>("leaveChat", listOf(Pair("chat_id", chatId)))

fun ApiContext.leaveChat(
    chatId: String,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>("leaveChat", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.leaveChatAwait(
    chatId: String
): Boolean? = sendRequestAwait<Boolean?>("leaveChat", listOf(Pair("chat_id", chatId)))