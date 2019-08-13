@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped [Poll][Poll] with the final results is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[messageId] Identifier of the original message with the poll
 * @param[replyMarkup] A JSON-serialized object for a new message [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun ApiContext.stopPoll(
    chatId: String,
    messageId: Int,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Poll?> = sendRequest<Poll?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup)),
    object : TypeReference<Poll> {})

fun ApiContext.stopPoll(
    chatId: String,
    messageId: Int,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<Poll?>) -> Unit
): ApiContext = sendRequestCallback<Poll?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup)),
    callback,
    object : TypeReference<Poll> {})

suspend fun ApiContext.stopPollAwait(
    chatId: String,
    messageId: Int,
    replyMarkup: InlineKeyboardMarkup? = null
): Poll? = sendRequestAwait<Poll?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup)),
    object : TypeReference<Poll> {})