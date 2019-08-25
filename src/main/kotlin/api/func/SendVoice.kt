@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import api.type.Audio
import api.type.Document
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as [Audio][Audio] or [Document][Document]). On success, the sent [Message][Message] is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[voice] Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[caption] Voice message caption, 0-1024 characters
 * @param[parseMode] Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[duration] Duration of the voice message in seconds
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendVoice(
    chatId: String,
    voice: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<SendVoiceResult> = sendRequest<SendVoiceResult>(
    "sendVoice",
    listOf(
        Pair("chat_id", chatId),
        Pair("voice", voice),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendVoice(
    chatId: String,
    voice: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: AsyncResult<SendVoiceResult>) -> Unit
): ApiContext = sendRequestCallback<SendVoiceResult>(
    "sendVoice",
    listOf(
        Pair("chat_id", chatId),
        Pair("voice", voice),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendVoiceAwait(
    chatId: String,
    voice: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): SendVoiceResult = sendRequestAwait<SendVoiceResult>(
    "sendVoice",
    listOf(
        Pair("chat_id", chatId),
        Pair("voice", voice),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)