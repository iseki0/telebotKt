@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.*
import api.type.InlineKeyboardMarkup
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to edit captions of messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[caption] New caption of the message
 * @param[parseMode] Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in the media caption.
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun ApiContext.editMessageCaption(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageCaptionResultMessage?> = sendRequest<EditMessageCaptionResultMessage?>(
    "editMessageCaption",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageCaption(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageCaptionResultMessage?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageCaptionResultMessage?>(
    "editMessageCaption",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageCaptionAwait(
    chatId: String,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageCaptionResultMessage? = sendRequestAwait<EditMessageCaptionResultMessage?>(
    "editMessageCaption",
    listOf(
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    )
)


fun ApiContext.editMessageCaption(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<EditMessageCaptionResultBoolean?> = sendRequest<EditMessageCaptionResultBoolean?>(
    "editMessageCaption",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.editMessageCaption(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<EditMessageCaptionResultBoolean?>) -> Unit
): ApiContext = sendRequestCallback<EditMessageCaptionResultBoolean?>(
    "editMessageCaption",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.editMessageCaptionAwait(
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): EditMessageCaptionResultBoolean? = sendRequestAwait<EditMessageCaptionResultBoolean?>(
    "editMessageCaption",
    listOf(
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    )
)