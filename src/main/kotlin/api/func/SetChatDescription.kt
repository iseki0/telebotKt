@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.SetChatDescriptionResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[description] New chat description, 0-255 characters
 */
fun ApiContext.setChatDescription(
    chatId: String,
    description: String? = null
): Future<SetChatDescriptionResult> = sendRequest<SetChatDescriptionResult>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description))
)

fun ApiContext.setChatDescription(
    chatId: String,
    description: String? = null,
    callback: (result: AsyncResult<SetChatDescriptionResult>) -> Unit
): ApiContext = sendRequestCallback<SetChatDescriptionResult>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description)),
    callback
)

suspend fun ApiContext.setChatDescriptionAwait(
    chatId: String,
    description: String? = null
): SetChatDescriptionResult = sendRequestAwait<SetChatDescriptionResult>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description))
)