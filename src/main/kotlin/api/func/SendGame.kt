@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.SendGameResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.InlineKeyboardMarkup
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to send a game. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat
 * @param[gameShortName] Short name of the game, serves as the unique identifier for the game. Set up your games via [Botfather](https://t.me/botfather).
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If empty, one ‘Play game_title’ button will be shown. If not empty, the first button must launch the game.
 */
fun ApiContext.sendGame(
    chatId: Int,
    gameShortName: String,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<SendGameResult?> = sendRequest<SendGameResult?>(
    "sendGame",
    listOf(
        Pair("chat_id", chatId),
        Pair("game_short_name", gameShortName),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendGame(
    chatId: Int,
    gameShortName: String,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<SendGameResult?>) -> Unit
): ApiContext = sendRequestCallback<SendGameResult?>(
    "sendGame",
    listOf(
        Pair("chat_id", chatId),
        Pair("game_short_name", gameShortName),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendGameAwait(
    chatId: Int,
    gameShortName: String,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): SendGameResult? = sendRequestAwait<SendGameResult?>(
    "sendGame",
    listOf(
        Pair("chat_id", chatId),
        Pair("game_short_name", gameShortName),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)