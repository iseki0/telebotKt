@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to send a group of photos or videos as an album. On success, an array of the sent [Messages][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[media] A JSON-serialized array describing photos and videos to be sent, must include 2–10 items
 * @param[disableNotification] Sends the messages [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the messages are a reply, ID of the original message
 */
fun ApiContext.sendMediaGroup(
    chatId: String,
    media: List<InputMediaPhoto>,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null
): Future<Array<Message>?> = sendRequest<Array<Message>?>(
    "sendMediaGroup",
    listOf(
        Pair("chat_id", chatId),
        Pair("media", media),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId)
    ),
    object : TypeReference<Array<Message>> {})

fun ApiContext.sendMediaGroup(
    chatId: String,
    media: List<InputMediaPhoto>,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    callback: (result: AsyncResult<Array<Message>?>) -> Unit
): ApiContext = sendRequestCallback<Array<Message>?>(
    "sendMediaGroup",
    listOf(
        Pair("chat_id", chatId),
        Pair("media", media),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId)
    ),
    callback,
    object : TypeReference<Array<Message>> {})

suspend fun ApiContext.sendMediaGroupAwait(
    chatId: String,
    media: List<InputMediaPhoto>,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null
): Array<Message>? = sendRequestAwait<Array<Message>?>(
    "sendMediaGroup",
    listOf(
        Pair("chat_id", chatId),
        Pair("media", media),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId)
    ),
    object : TypeReference<Array<Message>> {})