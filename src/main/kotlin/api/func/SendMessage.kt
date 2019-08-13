@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to send text messages. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[text] Text of the message to be sent
 * @param[parseMode] Send [*Markdown*](https://core.telegram.org#markdown-style) or [*HTML*](https://core.telegram.org#html-style), if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs](https://core.telegram.org#formatting-options) in your bot's message.
 * @param[disableWebPagePreview] Disables link previews for links in this message
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendMessage(
    chatId: String,
    text: String,
    parseMode: String? = null,
    disableWebPagePreview: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("text", text),
        Pair("parse_mode", parseMode),
        Pair("disable_web_page_preview", disableWebPagePreview),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})

fun ApiContext.sendMessage(
    chatId: String,
    text: String,
    parseMode: String? = null,
    disableWebPagePreview: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: AsyncResult<Message?>) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("text", text),
        Pair("parse_mode", parseMode),
        Pair("disable_web_page_preview", disableWebPagePreview),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Message> {})

suspend fun ApiContext.sendMessageAwait(
    chatId: String,
    text: String,
    parseMode: String? = null,
    disableWebPagePreview: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendMessage",
    listOf(
        Pair("chat_id", chatId),
        Pair("text", text),
        Pair("parse_mode", parseMode),
        Pair("disable_web_page_preview", disableWebPagePreview),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})