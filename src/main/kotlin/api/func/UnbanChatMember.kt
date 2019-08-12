@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*

/**
 * Use this method to unban a previously kicked user in a supergroup or channel. The user will **not** return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target group or username of the target supergroup or channel (in the format `@username`)
 * @param[userId] Unique identifier of the target user
 */
fun ApiContext.unbanChatMember(
    chatId: String,
    userId: Int
): Future<Boolean?> = sendRequest<Boolean?>("unbanChatMember", listOf(Pair("chat_id", chatId), Pair("user_id", userId)))

fun ApiContext.unbanChatMember(
    chatId: String,
    userId: Int,
    callback: (result: Boolean?) -> Unit
): ApiContext =
    sendRequestCallback<Boolean?>("unbanChatMember", listOf(Pair("chat_id", chatId), Pair("user_id", userId)), callback)

suspend fun ApiContext.unbanChatMemberAwait(
    chatId: String,
    userId: Int
): Boolean? = sendRequestAwait<Boolean?>("unbanChatMember", listOf(Pair("chat_id", chatId), Pair("user_id", userId)))