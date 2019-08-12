@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Message

/**
 * Use this method to forward messages of any kind. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[fromChatId] Unique identifier for the chat where the original message was sent (or channel username in the format `@channelusername`)
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[messageId] Message identifier in the chat specified in *from_chat_id*
 */
fun ApiContext.forwardMessage(
    chatId: String,
    fromChatId: String,
    disableNotification: Boolean? = null,
    messageId: Int
): Future<Message?> = sendRequest<Message?>(
    "forwardMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("from_chat_id", fromChatId),
        Pair("disable_notification", disableNotification),
        Pair("message_id", messageId)
    )
)

fun ApiContext.forwardMessage(
    chatId: String,
    fromChatId: String,
    disableNotification: Boolean? = null,
    messageId: Int,
    callback: (result: Message?) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "forwardMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("from_chat_id", fromChatId),
        Pair("disable_notification", disableNotification),
        Pair("message_id", messageId)
    ),
    callback
)

suspend fun ApiContext.forwardMessageAwait(
    chatId: String,
    fromChatId: String,
    disableNotification: Boolean? = null,
    messageId: Int
): Message? = sendRequestAwait<Message?>(
    "forwardMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("from_chat_id", fromChatId),
        Pair("disable_notification", disableNotification),
        Pair("message_id", messageId)
    )
)