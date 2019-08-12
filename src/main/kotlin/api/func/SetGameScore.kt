@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Message
import io.vertx.core.Future

/**
 * Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited [Message][Message], otherwise returns *True*. Returns an error, if the new score is not greater than the user's current score in the chat and *force* is *False*.
 *
 * @param[userId] User identifier
 * @param[score] New score, must be non-negative
 * @param[force] Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
 * @param[disableEditMessage] Pass True, if the game message should not be automatically edited to include the current scoreboard
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the sent message
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 */
fun ApiContext.setGameScore(
    userId: Int,
    score: Int,
    force: Boolean? = null,
    disableEditMessage: Boolean? = null,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): Future<Either<Message, Boolean>?> = sendRequest<Either<Message, Boolean>?>(
    "setGameScore",
    listOf(
        Pair("user_id", userId),
        Pair("score", score),
        Pair("force", force),
        Pair("disable_edit_message", disableEditMessage),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    )
)

fun ApiContext.setGameScore(
    userId: Int,
    score: Int,
    force: Boolean? = null,
    disableEditMessage: Boolean? = null,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    callback: (result: Either<Message, Boolean>?) -> Unit
): ApiContext = sendRequestCallback<Either<Message, Boolean>?>(
    "setGameScore",
    listOf(
        Pair("user_id", userId),
        Pair("score", score),
        Pair("force", force),
        Pair("disable_edit_message", disableEditMessage),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    ),
    callback
)

suspend fun ApiContext.setGameScoreAwait(
    userId: Int,
    score: Int,
    force: Boolean? = null,
    disableEditMessage: Boolean? = null,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): Either<Message, Boolean>? = sendRequestAwait<Either<Message, Boolean>?>(
    "setGameScore",
    listOf(
        Pair("user_id", userId),
        Pair("score", score),
        Pair("force", force),
        Pair("disable_edit_message", disableEditMessage),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    )
)