@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Describes actions that a non-administrator user is allowed to take in a chat.
 *
 * @param[canSendMessages] *Optional*. True, if the user is allowed to send text messages, contacts, locations and venues
 * @param[canSendMediaMessages] *Optional*. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
 * @param[canSendPolls] *Optional*. True, if the user is allowed to send polls, implies can_send_messages
 * @param[canSendOtherMessages] *Optional*. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
 * @param[canAddWebPagePreviews] *Optional*. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
 * @param[canChangeInfo] *Optional*. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
 * @param[canInviteUsers] *Optional*. True, if the user is allowed to invite new users to the chat
 * @param[canPinMessages] *Optional*. True, if the user is allowed to pin messages. Ignored in public supergroups
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ChatPermissions @JsonCreator constructor(
    @get:JsonProperty("can_send_messages")
    @JsonProperty("can_send_messages")
    val canSendMessages: Boolean? = null,
    @get:JsonProperty("can_send_media_messages")
    @JsonProperty("can_send_media_messages")
    val canSendMediaMessages: Boolean? = null,
    @get:JsonProperty("can_send_polls")
    @JsonProperty("can_send_polls")
    val canSendPolls: Boolean? = null,
    @get:JsonProperty("can_send_other_messages")
    @JsonProperty("can_send_other_messages")
    val canSendOtherMessages: Boolean? = null,
    @get:JsonProperty("can_add_web_page_previews")
    @JsonProperty("can_add_web_page_previews")
    val canAddWebPagePreviews: Boolean? = null,
    @get:JsonProperty("can_change_info")
    @JsonProperty("can_change_info")
    val canChangeInfo: Boolean? = null,
    @get:JsonProperty("can_invite_users")
    @JsonProperty("can_invite_users")
    val canInviteUsers: Boolean? = null,
    @get:JsonProperty("can_pin_messages")
    @JsonProperty("can_pin_messages")
    val canPinMessages: Boolean? = null
)