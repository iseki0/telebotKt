@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass *False* for all boolean parameters to demote a user. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[userId] Unique identifier of the target user
 * @param[canChangeInfo] Pass True, if the administrator can change chat title, photo and other settings
 * @param[canPostMessages] Pass True, if the administrator can create channel posts, channels only
 * @param[canEditMessages] Pass True, if the administrator can edit messages of other users and can pin messages, channels only
 * @param[canDeleteMessages] Pass True, if the administrator can delete messages of other users
 * @param[canInviteUsers] Pass True, if the administrator can invite new users to the chat
 * @param[canRestrictMembers] Pass True, if the administrator can restrict, ban or unban chat members
 * @param[canPinMessages] Pass True, if the administrator can pin messages, supergroups only
 * @param[canPromoteMembers] Pass True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
 */
fun ApiContext.promoteChatMember(
    chatId: String,
    userId: Int,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null
): Future<PromoteChatMemberResult?> = sendRequest<PromoteChatMemberResult?>(
    "promoteChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("can_change_info", canChangeInfo),
        Pair("can_post_messages", canPostMessages),
        Pair("can_edit_messages", canEditMessages),
        Pair("can_delete_messages", canDeleteMessages),
        Pair("can_invite_users", canInviteUsers),
        Pair("can_restrict_members", canRestrictMembers),
        Pair("can_pin_messages", canPinMessages),
        Pair("can_promote_members", canPromoteMembers)
    )
)

fun ApiContext.promoteChatMember(
    chatId: String,
    userId: Int,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null,
    callback: (result: AsyncResult<PromoteChatMemberResult?>) -> Unit
): ApiContext = sendRequestCallback<PromoteChatMemberResult?>(
    "promoteChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("can_change_info", canChangeInfo),
        Pair("can_post_messages", canPostMessages),
        Pair("can_edit_messages", canEditMessages),
        Pair("can_delete_messages", canDeleteMessages),
        Pair("can_invite_users", canInviteUsers),
        Pair("can_restrict_members", canRestrictMembers),
        Pair("can_pin_messages", canPinMessages),
        Pair("can_promote_members", canPromoteMembers)
    ),
    callback
)

suspend fun ApiContext.promoteChatMemberAwait(
    chatId: String,
    userId: Int,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null
): PromoteChatMemberResult? = sendRequestAwait<PromoteChatMemberResult?>(
    "promoteChatMember",
    listOf(
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("can_change_info", canChangeInfo),
        Pair("can_post_messages", canPostMessages),
        Pair("can_edit_messages", canEditMessages),
        Pair("can_delete_messages", canDeleteMessages),
        Pair("can_invite_users", canInviteUsers),
        Pair("can_restrict_members", canRestrictMembers),
        Pair("can_pin_messages", canPinMessages),
        Pair("can_promote_members", canPromoteMembers)
    )
)