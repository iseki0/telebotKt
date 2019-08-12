@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.ApiContext
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.ChatPermissions
import io.vertx.core.Future

/**
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass *True* for all permissions to lift restrictions from a user. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format `@supergroupusername`)
 * @param[userId] Unique identifier of the target user
 * @param[permissions] New user permissions
 * @param[untilDate] Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
 */
fun ApiContext.restrictChatMember(
    chatId: String,
    userId: Int,
    permissions: ChatPermissions,
    untilDate: Int? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "restrictChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("permissions", permissions),
        Pair("until_date", untilDate)
    )
)

fun ApiContext.restrictChatMember(
    chatId: String,
    userId: Int,
    permissions: ChatPermissions,
    untilDate: Int? = null,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "restrictChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("permissions", permissions),
        Pair("until_date", untilDate)
    ),
    callback
)

suspend fun ApiContext.restrictChatMemberAwait(
    chatId: String,
    userId: Int,
    permissions: ChatPermissions,
    untilDate: Int? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "restrictChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("permissions", permissions),
        Pair("until_date", untilDate)
    )
)