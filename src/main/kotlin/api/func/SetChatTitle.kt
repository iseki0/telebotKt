@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * >  Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[title] New chat title, 1-255 characters
 */
fun ApiContext.setChatTitle(
    chatId: String,
    title: String
): Future<Boolean?> = sendRequest<Boolean?>(
    "setChatTitle",
    listOf(Pair("chat_id", chatId), Pair("title", title)),
    object : TypeReference<Boolean> {})

fun ApiContext.setChatTitle(
    chatId: String,
    title: String,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setChatTitle",
    listOf(Pair("chat_id", chatId), Pair("title", title)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.setChatTitleAwait(
    chatId: String,
    title: String
): Boolean? = sendRequestAwait<Boolean?>(
    "setChatTitle",
    listOf(Pair("chat_id", chatId), Pair("title", title)),
    object : TypeReference<Boolean> {})