@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.InlineKeyboardMarkup
import api.type.Message
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
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Message, Boolean>?> = sendRequest<Either<Message, Boolean>?>(
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
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: Either<Message, Boolean>?) -> Unit
): ApiContext = sendRequestCallback<Either<Message, Boolean>?>(
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
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Either<Message, Boolean>? = sendRequestAwait<Either<Message, Boolean>?>(
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