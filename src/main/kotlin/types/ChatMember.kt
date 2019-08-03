package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object contains information about one member of a chat.
 *
 * @param[user] Information about the user
 * @param[status] The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
 * @param[untilDate] *Optional*. Restricted and kicked only. Date when restrictions will be lifted for this user, unix time
 * @param[canBeEdited] *Optional*. Administrators only. True, if the bot is allowed to edit administrator privileges of that user
 * @param[canChangeInfo] *Optional*. Administrators and restricted only. True, if the administrator can change the chat title, photo and other settings
 * @param[canPostMessages] *Optional*. Administrators only. True, if the administrator can post in the channel, channels only
 * @param[canEditMessages] *Optional*. Administrators only. True, if the administrator can edit messages of other users and can pin messages, channels only
 * @param[canDeleteMessages] *Optional*. Administrators only. True, if the administrator can delete messages of other users
 * @param[canInviteUsers] *Optional*. Administrators and restricted only. True, if the administrator can invite new users to the chat
 * @param[canRestrictMembers] *Optional*. Administrators only. True, if the administrator can restrict, ban or unban chat members
 * @param[canPinMessages] *Optional*. Administrators and restricted only. True, if the administrator can pin messages, groups and supergroups only
 * @param[canPromoteMembers] *Optional*. Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
 * @param[isMember] *Optional*. Restricted only. True, if the user is a member of the chat at the moment of the request
 * @param[canSendMessages] *Optional*. Restricted only. True, if the user can send text messages, contacts, locations and venues
 * @param[canSendMediaMessages] *Optional*. Restricted only. True, if the user can send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @param[canSendPolls] *Optional*. Restricted only. True, if the user is allowed to send polls
 * @param[canSendOtherMessages] *Optional*. Restricted only. True, if the user can send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @param[canAddWebPagePreviews] *Optional*. Restricted only. True, if user may add web page previews to his messages, implies can_send_media_messages
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChatMember @JsonCreator constructor(
    @JsonProperty("user")
    val user: User,
    @JsonProperty("status")
    val status: String,
    @JsonProperty("until_date")
    val untilDate: Int? = null,
    @JsonProperty("can_be_edited")
    val canBeEdited: Boolean? = null,
    @JsonProperty("can_change_info")
    val canChangeInfo: Boolean? = null,
    @JsonProperty("can_post_messages")
    val canPostMessages: Boolean? = null,
    @JsonProperty("can_edit_messages")
    val canEditMessages: Boolean? = null,
    @JsonProperty("can_delete_messages")
    val canDeleteMessages: Boolean? = null,
    @JsonProperty("can_invite_users")
    val canInviteUsers: Boolean? = null,
    @JsonProperty("can_restrict_members")
    val canRestrictMembers: Boolean? = null,
    @JsonProperty("can_pin_messages")
    val canPinMessages: Boolean? = null,
    @JsonProperty("can_promote_members")
    val canPromoteMembers: Boolean? = null,
    @JsonProperty("is_member")
    val isMember: Boolean? = null,
    @JsonProperty("can_send_messages")
    val canSendMessages: Boolean? = null,
    @JsonProperty("can_send_media_messages")
    val canSendMediaMessages: Boolean? = null,
    @JsonProperty("can_send_polls")
    val canSendPolls: Boolean? = null,
    @JsonProperty("can_send_other_messages")
    val canSendOtherMessages: Boolean? = null,
    @JsonProperty("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean? = null
)