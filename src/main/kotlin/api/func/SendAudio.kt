@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Message

/**
 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .mp3 format. On success, the sent [Message][Message] is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * For sending voice messages, use the [sendVoice][sendVoice] method instead.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[audio] Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[caption] Audio caption, 0-1024 characters
 * @param[parseMode] Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[duration] Duration of the audio in seconds
 * @param[performer] Performer
 * @param[title] Track name
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendAudio(
    chatId: String,
    audio: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    performer: String? = null,
    title: String? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendAudio",
    listOf(
        Pair("chat_id", chatId),
        Pair("audio", audio),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("performer", performer),
        Pair("title", title),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendAudio(
    chatId: String,
    audio: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    performer: String? = null,
    title: String? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: Message?) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendAudio",
    listOf(
        Pair("chat_id", chatId),
        Pair("audio", audio),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("performer", performer),
        Pair("title", title),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendAudioAwait(
    chatId: String,
    audio: InputFile,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    performer: String? = null,
    title: String? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendAudio",
    listOf(
        Pair("chat_id", chatId),
        Pair("audio", audio),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("performer", performer),
        Pair("title", title),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)