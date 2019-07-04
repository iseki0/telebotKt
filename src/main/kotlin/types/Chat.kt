package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
 * @param[allMembersAreAdministrators] *Optional*. True if a group has ‘All Members Are Admins’ enabled.
 * @param[photo] *Optional*. types.Chat photo. Returned only in [getChat][getChat].
 * @param[description] *Optional*. Description, for supergroups and channel chats. Returned only in [getChat][getChat].
 * @param[inviteLink] *Optional*. types.Chat invite link, for supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using [exportChatInviteLink][exportChatInviteLink]. Returned only in [getChat][getChat].
 * @param[pinnedMessage] *Optional*. Pinned message, for groups, supergroups and channels. Returned only in [getChat][getChat].
 * @param[stickerSetName] *Optional*. For supergroups, name of group sticker set. Returned only in [getChat][getChat].
 * @param[canSetStickerSet] *Optional*. True, if the bot can change the group sticker set. Returned only in [getChat][getChat].
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Chat @JsonCreator constructor(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("username")
    val username: String?,
    @JsonProperty("first_name")
    val firstName: String?,
    @JsonProperty("last_name")
    val lastName: String?,
    @JsonProperty("all_members_are_administrators")
    val allMembersAreAdministrators: Boolean?,
    @JsonProperty("photo")
    val photo: ChatPhoto?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("invite_link")
    val inviteLink: String?,
    @JsonProperty("pinned_message")
    val pinnedMessage: Message?,
    @JsonProperty("sticker_set_name")
    val stickerSetName: String?,
    @JsonProperty("can_set_sticker_set")
    val canSetStickerSet: Boolean?
)