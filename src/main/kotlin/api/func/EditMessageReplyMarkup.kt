@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun ApiContext.editMessageReplyMarkup(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Message, Boolean>?> = sendRequest<Either<Message, Boolean>?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Either<Message, Boolean>> {})

fun ApiContext.editMessageReplyMarkup(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<Either<Message, Boolean>?>) -> Unit
): ApiContext = sendRequestCallback<Either<Message, Boolean>?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Either<Message, Boolean>> {})

suspend fun ApiContext.editMessageReplyMarkupAwait(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Either<Message, Boolean>? = sendRequestAwait<Either<Message, Boolean>?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Either<Message, Boolean>> {})