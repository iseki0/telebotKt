@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import api.type.InlineKeyboardMarkup
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun ApiContext.editMessageReplyMarkup(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageReplyMarkupResultMessage?> = sendRequest<EditMessageReplyMarkupResultMessage?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageReplyMarkup(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageReplyMarkupResultMessage?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageReplyMarkupResultMessage?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageReplyMarkupAwait(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageReplyMarkupResultMessage? = sendRequestAwait<EditMessageReplyMarkupResultMessage?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageReplyMarkup(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageReplyMarkupResultBoolean?> = sendRequest<EditMessageReplyMarkupResultBoolean?>(
    "editMessageReplyMarkup",
    listOf(Pair("message_id", messageId), Pair("inline_message_id", inlineMessageId), Pair("reply_markup", replyMarkup))
)

fun ApiContext.editMessageReplyMarkup(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageReplyMarkupResultBoolean?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageReplyMarkupResultBoolean?>(
    "editMessageReplyMarkup",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageReplyMarkupAwait(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageReplyMarkupResultBoolean? = sendRequestAwait<EditMessageReplyMarkupResultBoolean?>(
    "editMessageReplyMarkup",
    listOf(Pair("message_id", messageId), Pair("inline_message_id", inlineMessageId), Pair("reply_markup", replyMarkup))
)