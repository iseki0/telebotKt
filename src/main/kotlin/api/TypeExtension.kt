package api

import ApiContext
import api.func.sendMessage
import api.type.Message

fun ApiContext.reply(src: Message, text: String, parseMode: ParseMode? = autoDetectParseMode(text)) =
    sendMessage(
        chatId = src.chat.id.toString(),
        text = text,
        replyToMessageId = src.messageId,
        parseMode = parseMode
    )

val HTMLParseModePattern = Regex("</?[A-Za-z][A-Za-z0-9]*(?:\\s[^>]*)?>")
fun autoDetectParseMode(str: String): ParseMode =
    if (HTMLParseModePattern.findAll(str).count() > 1) {
        ParseMode.HTML
    } else ParseMode.MARKDOWN