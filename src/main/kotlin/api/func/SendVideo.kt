@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Document
import api.type.Message
import io.vertx.core.Future

/**
 * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as [Document][Document]). On success, the sent [Message][Message] is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[video] Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[duration] Duration of sent video in seconds
 * @param[width] Video width
 * @param[height] Video height
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[caption] Video caption (may also be used when resending videos by *file_id*), 0-1024 characters
 * @param[parseMode] Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[supportsStreaming] Pass *True*, if the uploaded video is suitable for streaming
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendVideo(
    chatId: String,
    video: InputFile,
    duration: Int? = null,
    width: Int? = null,
    height: Int? = null,
    thumb: InputFile? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    supportsStreaming: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendVideo",
    listOf(
        Pair("chat_id", chatId),
        Pair("video", video),
        Pair("duration", duration),
        Pair("width", width),
        Pair("height", height),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("supports_streaming", supportsStreaming),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendVideo(
    chatId: String,
    video: InputFile,
    duration: Int? = null,
    width: Int? = null,
    height: Int? = null,
    thumb: InputFile? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    supportsStreaming: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: Message?) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendVideo",
    listOf(
        Pair("chat_id", chatId),
        Pair("video", video),
        Pair("duration", duration),
        Pair("width", width),
        Pair("height", height),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("supports_streaming", supportsStreaming),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendVideoAwait(
    chatId: String,
    video: InputFile,
    duration: Int? = null,
    width: Int? = null,
    height: Int? = null,
    thumb: InputFile? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    supportsStreaming: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendVideo",
    listOf(
        Pair("chat_id", chatId),
        Pair("video", video),
        Pair("duration", duration),
        Pair("width", width),
        Pair("height", height),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("supports_streaming", supportsStreaming),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)