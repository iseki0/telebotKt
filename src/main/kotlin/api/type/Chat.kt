@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.ChatType
import api.func.exportChatInviteLink
import api.func.getChat
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a chat.
 *
 * @param[id] Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @param[type] Type of chat, can be either “private”, “group”, “supergroup” or “channel”
 * @param[title] *Optional*. Title, for supergroups, channels and group chats
 * @param[username] *Optional*. Username, for private chats, supergroups and channels if available
 * @param[firstName] *Optional*. First name of the other party in a private chat
 * @param[lastName] *Optional*. Last name of the other party in a private chat
 * @param[photo] *Optional*. Chat photo. Returned only in [getChat][getChat].
 * @param[description] *Optional*. Description, for groups, supergroups and channel chats. Returned only in [getChat][getChat].
 * @param[inviteLink] *Optional*. Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using [exportChatInviteLink][exportChatInviteLink]. Returned only in [getChat][getChat].
 * @param[pinnedMessage] *Optional*. Pinned message, for groups, supergroups and channels. Returned only in [getChat][getChat].
 * @param[permissions] *Optional*. Default chat member permissions, for groups and supergroups. Returned only in [getChat][getChat].
 * @param[stickerSetName] *Optional*. For supergroups, name of group sticker set. Returned only in [getChat][getChat].
 * @param[canSetStickerSet] *Optional*. True, if the bot can change the group sticker set. Returned only in [getChat][getChat].
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Chat @JsonCreator constructor(
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: Long,
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: ChatType,
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String? = null,
    @get:JsonProperty("username")
    @JsonProperty("username")
    val username: String? = null,
    @get:JsonProperty("first_name")
    @JsonProperty("first_name")
    val firstName: String? = null,
    @get:JsonProperty("last_name")
    @JsonProperty("last_name")
    val lastName: String? = null,
    @get:JsonProperty("photo")
    @JsonProperty("photo")
    val photo: ChatPhoto? = null,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String? = null,
    @get:JsonProperty("invite_link")
    @JsonProperty("invite_link")
    val inviteLink: String? = null,
    @get:JsonProperty("pinned_message")
    @JsonProperty("pinned_message")
    val pinnedMessage: Message? = null,
    @get:JsonProperty("permissions")
    @JsonProperty("permissions")
    val permissions: ChatPermissions? = null,
    @get:JsonProperty("sticker_set_name")
    @JsonProperty("sticker_set_name")
    val stickerSetName: String? = null,
    @get:JsonProperty("can_set_sticker_set")
    @JsonProperty("can_set_sticker_set")
    val canSetStickerSet: Boolean? = null
)