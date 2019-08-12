@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.GameHighScore

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
): Future<List<GameHighScore>?> = sendRequest<List<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    )
)

fun ApiContext.getGameHighScores(
    userId: Int,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    callback: (result: List<GameHighScore>?) -> Unit
): ApiContext = sendRequestCallback<List<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    ),
    callback
)

suspend fun ApiContext.getGameHighScoresAwait(
    userId: Int,
    chatId: Int? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): List<GameHighScore>? = sendRequestAwait<List<GameHighScore>?>(
    "getGameHighScores",
    listOf(
        Pair("user_id", userId),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    )
)