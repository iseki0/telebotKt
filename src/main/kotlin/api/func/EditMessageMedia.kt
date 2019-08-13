@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

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
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Message, Boolean>?> = sendRequest<Either<Message, Boolean>?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Either<Message, Boolean>> {})

fun ApiContext.editMessageMedia(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<Either<Message, Boolean>?>) -> Unit
): ApiContext = sendRequestCallback<Either<Message, Boolean>?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Either<Message, Boolean>> {})

suspend fun ApiContext.editMessageMediaAwait(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): Either<Message, Boolean>? = sendRequestAwait<Either<Message, Boolean>?>(
    "editMessageMedia",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Either<Message, Boolean>> {})