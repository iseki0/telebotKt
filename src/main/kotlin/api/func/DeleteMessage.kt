@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*

/**
 * Use this method to delete a message, including service messages, with the following limitations:
 * - A message can only be deleted if it was sent less than 48 hours ago.
 * - Bots can delete outgoing messages in private chats, groups, and supergroups.
 * - Bots can delete incoming messages in private chats.
 * - Bots granted *can_post_messages* permissions can delete outgoing messages in channels.
 * - If the bot is an administrator of a group, it can delete any message there.
 * - If the bot has *can_delete_messages* permission in a supergroup or a channel, it can delete any message there.
 * Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Identifier of the message to delete
 */
fun ApiContext.deleteMessage(
    chatId: String,
    messageId: Int
): Future<Boolean?> =
    sendRequest<Boolean?>("deleteMessage", listOf(Pair("chat_id", chatId), Pair("message_id", messageId)))

fun ApiContext.deleteMessage(
    chatId: String,
    messageId: Int,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "deleteMessage",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId)),
    callback
)

suspend fun ApiContext.deleteMessageAwait(
    chatId: String,
    messageId: Int
): Boolean? =
    sendRequestAwait<Boolean?>("deleteMessage", listOf(Pair("chat_id", chatId), Pair("message_id", messageId)))