@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import api.type.InlineKeyboardMarkup
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message type can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[media] A JSON-serialized object for a new media content of the message
 * @param[replyMarkup] A JSON-serialized object for a new [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun ApiContext.editMessageMedia(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageMediaResultMessage?> = sendRequest<EditMessageMediaResultMessage?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageMedia(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageMediaResultMessage?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageMediaResultMessage?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageMediaAwait(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageMediaResultMessage? = sendRequestAwait<EditMessageMediaResultMessage?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageMedia(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageMediaResultBoolean?> = sendRequest<EditMessageMediaResultBoolean?>(
    "editMessageMedia",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageMedia(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageMediaResultBoolean?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageMediaResultBoolean?>(
    "editMessageMedia",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageMediaAwait(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageMediaResultBoolean? = sendRequestAwait<EditMessageMediaResultBoolean?>(
    "editMessageMedia",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    )
)