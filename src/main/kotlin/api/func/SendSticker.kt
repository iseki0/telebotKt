@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to send static .WEBP or [animated](https://telegram.org/blog/animated-stickers) .TGS stickers. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[sticker] Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .webp file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendSticker(
    chatId: String,
    sticker: InputFile,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendSticker",
    listOf(
        Pair("chat_id", chatId),
        Pair("sticker", sticker),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})

fun ApiContext.sendSticker(
    chatId: String,
    sticker: InputFile,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: AsyncResult<Message?>) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendSticker",
    listOf(
        Pair("chat_id", chatId),
        Pair("sticker", sticker),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Message> {})

suspend fun ApiContext.sendStickerAwait(
    chatId: String,
    sticker: InputFile,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendSticker",
    listOf(
        Pair("chat_id", chatId),
        Pair("sticker", sticker),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})