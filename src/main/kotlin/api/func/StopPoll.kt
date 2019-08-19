@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.StopPollResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.InlineKeyboardMarkup
import api.type.Poll
import io.vertx.core.AsyncResult
import io.vertx.core.Future

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
): Future<StopPollResult?> = sendRequest<StopPollResult?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup))
)

fun ApiContext.stopPoll(
    chatId: String,
    messageId: Int,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<StopPollResult?>) -> Unit
): ApiContext = sendRequestCallback<StopPollResult?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup)),
    callback
)

suspend fun ApiContext.stopPollAwait(
    chatId: String,
    messageId: Int,
    replyMarkup: InlineKeyboardMarkup? = null
): StopPollResult? = sendRequestAwait<StopPollResult?>(
    "stopPoll",
    listOf(Pair("chat_id", chatId), Pair("message_id", messageId), Pair("reply_markup", replyMarkup))
)