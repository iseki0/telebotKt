@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to get data for high score tables. Will return the score of the specified user and several of his neighbors in a game. On success, returns an *Array* of [GameHighScore][GameHighScore] objects.
 * >  This method will currently return scores for the target user, plus two of his closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.
 *
 * @param[userId] Target user id
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the sent message
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 */
fun ApiContext.getGameHighScores(
    userId: Int,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): Future<Array<GameHighScore>?> = sendRequest<Array<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    ),
    object : TypeReference<Array<GameHighScore>> {})

fun ApiContext.getGameHighScores(
    userId: Int,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    callback: (result: AsyncResult<Array<GameHighScore>?>) -> Unit
): ApiContext = sendRequestCallback<Array<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    ),
    callback,
    object : TypeReference<Array<GameHighScore>> {})

suspend fun ApiContext.getGameHighScoresAwait(
    userId: Int,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): Array<GameHighScore>? = sendRequestAwait<Array<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    ),
    object : TypeReference<Array<GameHighScore>> {})