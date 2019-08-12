@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*

/**
 * Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless [unbanned][unbanChatMember] first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * >  Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group. Otherwise members may only be removed by the group's creator or by the member that added them.
 *
 * @param[chatId] Unique identifier for the target group or username of the target supergroup or channel (in the format `@channelusername`)
 * @param[userId] Unique identifier of the target user
 * @param[untilDate] Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
 */
fun ApiContext.kickChatMember(
    chatId: String,
    userId: Int,
    untilDate: Int? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "kickChatMember",
    listOf(Pair("chat_id", chatId), Pair("user_id", userId), Pair("until_date", untilDate))
)

fun ApiContext.kickChatMember(
    chatId: String,
    userId: Int,
    untilDate: Int? = null,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "kickChatMember",
    listOf(Pair("chat_id", chatId), Pair("user_id", userId), Pair("until_date", untilDate)),
    callback
)

suspend fun ApiContext.kickChatMemberAwait(
    chatId: String,
    userId: Int,
    untilDate: Int? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "kickChatMember",
    listOf(Pair("chat_id", chatId), Pair("user_id", userId), Pair("until_date", untilDate))
)