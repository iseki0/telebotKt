@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import ApiContext
import api.ExportChatInviteLinkResult
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to generate a new invite link for a chat; any previously generated link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns the new invite link as *String* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 */
fun ApiContext.exportChatInviteLink(
    chatId: String
): Future<ExportChatInviteLinkResult?> =
    sendRequest<ExportChatInviteLinkResult?>("exportChatInviteLink", listOf(Pair("chat_id", chatId)))

fun ApiContext.exportChatInviteLink(
    chatId: String,
    callback: (result: AsyncResult<ExportChatInviteLinkResult?>) -> Unit
): ApiContext =
    sendRequestCallback<ExportChatInviteLinkResult?>("exportChatInviteLink", listOf(Pair("chat_id", chatId)), callback)

suspend fun ApiContext.exportChatInviteLinkAwait(
    chatId: String
): ExportChatInviteLinkResult? =
    sendRequestAwait<ExportChatInviteLinkResult?>("exportChatInviteLink", listOf(Pair("chat_id", chatId)))