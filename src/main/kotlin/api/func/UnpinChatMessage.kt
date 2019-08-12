@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*

/**
 * Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 */
fun ApiContext.unpinChatMessage(
    chatId: String
): Future<Boolean?> = sendRequest<Boolean?>("unpinChatMessage", listOf(Pair("chat_id", chatId)))

fun ApiContext.unpinChatMessage(
    chatId: String,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>("unpinChatMessage", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.unpinChatMessageAwait(
    chatId: String
): Boolean? = sendRequestAwait<Boolean?>("unpinChatMessage", listOf(Pair("chat_id", chatId)))