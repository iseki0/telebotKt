@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Identifier of a message to pin
 * @param[disableNotification] Pass *True*, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
 */
fun ApiContext.pinChatMessage(
    chatId: String,
    messageId: Int,
    disableNotification: Boolean? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "pinChatMessage",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("disable_notification", disableNotification)),
    object : TypeReference<Boolean> {})

fun ApiContext.pinChatMessage(
    chatId: String,
    messageId: Int,
    disableNotification: Boolean? = null,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "pinChatMessage",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("disable_notification", disableNotification)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.pinChatMessageAwait(
    chatId: String,
    messageId: Int,
    disableNotification: Boolean? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "pinChatMessage",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("disable_notification", disableNotification)),
    object : TypeReference<Boolean> {})