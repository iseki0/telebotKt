@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.ChatPermissions
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the *can_restrict_members* admin rights. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format `@supergroupusername`)
 * @param[permissions] New default chat permissions
 */
fun ApiContext.setChatPermissions(
    chatId: String,
    permissions: ChatPermissions
): Future<SetChatPermissionsResult?> = sendRequest<SetChatPermissionsResult?>(
    "setChatPermissions",
    listOf(Pair("chat_id", chatId), Pair("permissions", permissions))
)

fun ApiContext.setChatPermissions(
    chatId: String,
    permissions: ChatPermissions,
    callback: (result: AsyncResult<SetChatPermissionsResult?>) -> Unit
): ApiContext = sendRequestCallback<SetChatPermissionsResult?>(
    "setChatPermissions",
    listOf(Pair("chat_id", chatId), Pair("permissions", permissions)),
    callback
)

suspend fun ApiContext.setChatPermissionsAwait(
    chatId: String,
    permissions: ChatPermissions
): SetChatPermissionsResult? = sendRequestAwait<SetChatPermissionsResult?>(
    "setChatPermissions",
    listOf(Pair("chat_id", chatId), Pair("permissions", permissions))
)