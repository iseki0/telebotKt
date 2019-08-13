@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[description] New chat description, 0-255 characters
 */
fun ApiContext.setChatDescription(
    chatId: String,
    description: String? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description)),
    object : TypeReference<Boolean> {})

fun ApiContext.setChatDescription(
    chatId: String,
    description: String? = null,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.setChatDescriptionAwait(
    chatId: String,
    description: String? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "setChatDescription",
    listOf(Pair("chat_id", chatId), Pair("description", description)),
    object : TypeReference<Boolean> {})