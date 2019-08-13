@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * As of [v.4.0](https://telegram.org/blog/video-messages-and-telescope), Telegram clients support rounded square mp4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[videoNote] Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. [More info on Sending Files »](https://core.telegram.org#sending-files). Sending video notes by a URL is currently unsupported
 * @param[duration] Duration of sent video in seconds
 * @param[length] Video width and height, i.e. diameter of the video message
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data under &lt;file_attach_name&gt;. [More info on Sending Files »](https://core.telegram.org#sending-files)
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendVideoNote(
    chatId: String,
    videoNote: InputFile,
    duration: Int? = null,
    length: Int? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendVideoNote",
    listOf(
        Pair("chat_id", chatId),
        Pair("video_note", videoNote),
        Pair("duration", duration),
        Pair("length", length),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})

fun ApiContext.sendVideoNote(
    chatId: String,
    videoNote: InputFile,
    duration: Int? = null,
    length: Int? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: AsyncResult<Message?>) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendVideoNote",
    listOf(
        Pair("chat_id", chatId),
        Pair("video_note", videoNote),
        Pair("duration", duration),
        Pair("length", length),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Message> {})

suspend fun ApiContext.sendVideoNoteAwait(
    chatId: String,
    videoNote: InputFile,
    duration: Int? = null,
    length: Int? = null,
    thumb: InputFile? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendVideoNote",
    listOf(
        Pair("chat_id", chatId),
        Pair("video_note", videoNote),
        Pair("duration", duration),
        Pair("length", length),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})