package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a message.
 *
 * @param[messageId] Unique message identifier inside this chat
 * @param[from] *Optional*. Sender, empty for messages sent to channels
 * @param[date] Date the message was sent in Unix time
 * @param[chat] Conversation the message belongs to
 * @param[forwardFrom] *Optional*. For forwarded messages, sender of the original message
 * @param[forwardFromChat] *Optional*. For messages forwarded from channels, information about the original channel
 * @param[forwardFromMessageId] *Optional*. For messages forwarded from channels, identifier of the original message in the channel
 * @param[forwardSignature] *Optional*. For messages forwarded from channels, signature of the post author if present
 * @param[forwardSenderName] *Optional*. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
 * @param[forwardDate] *Optional*. For forwarded messages, date the original message was sent in Unix time
 * @param[replyToMessage] *Optional*. For replies, the original message. Note that the types.Message object in this field will not contain further *reply_to_message* fields even if it itself is a reply.
 * @param[editDate] *Optional*. Date the message was last edited in Unix time
 * @param[mediaGroupId] *Optional*. The unique identifier of a media message group this message belongs to
 * @param[authorSignature] *Optional*. Signature of the post author for messages in channels
 * @param[text] *Optional*. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
 * @param[entities] *Optional*. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @param[captionEntities] *Optional*. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @param[audio] *Optional*. types.Message is an audio file, information about the file
 * @param[document] *Optional*. types.Message is a general file, information about the file
 * @param[animation] *Optional*. types.Message is an animation, information about the animation. For backward compatibility, when this field is set, the *document* field will also be set
 * @param[game] *Optional*. types.Message is a game, information about the game. [More about games »][null]
 * @param[photo] *Optional*. types.Message is a photo, available sizes of the photo
 * @param[sticker] *Optional*. types.Message is a sticker, information about the sticker
 * @param[video] *Optional*. types.Message is a video, information about the video
 * @param[voice] *Optional*. types.Message is a voice message, information about the file
 * @param[videoNote] *Optional*. types.Message is a [video note](https://telegram.org/blog/video-messages-and-telescope), information about the video message
 * @param[caption] *Optional*. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @param[contact] *Optional*. types.Message is a shared contact, information about the contact
 * @param[location] *Optional*. types.Message is a shared location, information about the location
 * @param[venue] *Optional*. types.Message is a venue, information about the venue
 * @param[poll] *Optional*. types.Message is a native poll, information about the poll
 * @param[newChatMembers] *Optional*. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
 * @param[leftChatMember] *Optional*. A member was removed from the group, information about them (this member may be the bot itself)
 * @param[newChatTitle] *Optional*. A chat title was changed to this value
 * @param[newChatPhoto] *Optional*. A chat photo was change to this value
 * @param[deleteChatPhoto] *Optional*. Service message: the chat photo was deleted
 * @param[groupChatCreated] *Optional*. Service message: the group has been created
 * @param[supergroupChatCreated] *Optional*. Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
 * @param[channelChatCreated] *Optional*. Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
 * @param[migrateToChatId] *Optional*. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @param[migrateFromChatId] *Optional*. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
 * @param[pinnedMessage] *Optional*. Specified message was pinned. Note that the types.Message object in this field will not contain further *reply_to_message* fields even if it is itself a reply.
 * @param[invoice] *Optional*. types.Message is an invoice for a [payment][null], information about the invoice. [More about payments »][null]
 * @param[successfulPayment] *Optional*. types.Message is a service message about a successful payment, information about the payment. [More about payments »][null]
 * @param[connectedWebsite] *Optional*. The domain name of the website on which the user has logged in. [More about Telegram Login »](https://core.telegram.org/widgets/login)
 * @param[passportData] *Optional*. Telegram Passport data
 * @param[replyMarkup] *Optional*. Inline keyboard attached to the message.  `login_url`  buttons are represented as ordinary  `url`  buttons.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Message @JsonCreator constructor(
    @JsonProperty("message_id")
    val messageId: Int,
    @JsonProperty("from")
    val from: User? = null,
    @JsonProperty("date")
    val date: Int,
    @JsonProperty("chat")
    val chat: Chat,
    @JsonProperty("forward_from")
    val forwardFrom: User? = null,
    @JsonProperty("forward_from_chat")
    val forwardFromChat: Chat? = null,
    @JsonProperty("forward_from_message_id")
    val forwardFromMessageId: Int? = null,
    @JsonProperty("forward_signature")
    val forwardSignature: String? = null,
    @JsonProperty("forward_sender_name")
    val forwardSenderName: String? = null,
    @JsonProperty("forward_date")
    val forwardDate: Int? = null,
    @JsonProperty("reply_to_message")
    val replyToMessage: Message? = null,
    @JsonProperty("edit_date")
    val editDate: Int? = null,
    @JsonProperty("media_group_id")
    val mediaGroupId: String? = null,
    @JsonProperty("author_signature")
    val authorSignature: String? = null,
    @JsonProperty("text")
    val text: String? = null,
    @JsonProperty("entities")
    val entities: Array<MessageEntity>?,
    @JsonProperty("caption_entities")
    val captionEntities: Array<MessageEntity>?,
    @JsonProperty("audio")
    val audio: Audio? = null,
    @JsonProperty("document")
    val document: Document? = null,
    @JsonProperty("animation")
    val animation: Animation? = null,
    @JsonProperty("game")
    val game: Game? = null,
    @JsonProperty("photo")
    val photo: Array<PhotoSize>?,
    @JsonProperty("sticker")
    val sticker: Sticker? = null,
    @JsonProperty("video")
    val video: Video? = null,
    @JsonProperty("voice")
    val voice: Voice? = null,
    @JsonProperty("video_note")
    val videoNote: VideoNote? = null,
    @JsonProperty("caption")
    val caption: String? = null,
    @JsonProperty("contact")
    val contact: Contact? = null,
    @JsonProperty("location")
    val location: Location? = null,
    @JsonProperty("venue")
    val venue: Venue? = null,
    @JsonProperty("poll")
    val poll: Poll? = null,
    @JsonProperty("new_chat_members")
    val newChatMembers: Array<User>?,
    @JsonProperty("left_chat_member")
    val leftChatMember: User? = null,
    @JsonProperty("new_chat_title")
    val newChatTitle: String? = null,
    @JsonProperty("new_chat_photo")
    val newChatPhoto: Array<PhotoSize>?,
    @JsonProperty("delete_chat_photo")
    val deleteChatPhoto: Boolean? = null,
    @JsonProperty("group_chat_created")
    val groupChatCreated: Boolean? = null,
    @JsonProperty("supergroup_chat_created")
    val supergroupChatCreated: Boolean? = null,
    @JsonProperty("channel_chat_created")
    val channelChatCreated: Boolean? = null,
    @JsonProperty("migrate_to_chat_id")
    val migrateToChatId: Int? = null,
    @JsonProperty("migrate_from_chat_id")
    val migrateFromChatId: Int? = null,
    @JsonProperty("pinned_message")
    val pinnedMessage: Message? = null,
    @JsonProperty("invoice")
    val invoice: Invoice? = null,
    @JsonProperty("successful_payment")
    val successfulPayment: SuccessfulPayment? = null,
    @JsonProperty("connected_website")
    val connectedWebsite: String? = null,
    @JsonProperty("passport_data")
    val passportData: PassportData? = null,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Message

        if (messageId != other.messageId) return false
        if (from != other.from) return false
        if (date != other.date) return false
        if (chat != other.chat) return false
        if (forwardFrom != other.forwardFrom) return false
        if (forwardFromChat != other.forwardFromChat) return false
        if (forwardFromMessageId != other.forwardFromMessageId) return false
        if (forwardSignature != other.forwardSignature) return false
        if (forwardSenderName != other.forwardSenderName) return false
        if (forwardDate != other.forwardDate) return false
        if (replyToMessage != other.replyToMessage) return false
        if (editDate != other.editDate) return false
        if (mediaGroupId != other.mediaGroupId) return false
        if (authorSignature != other.authorSignature) return false
        if (text != other.text) return false
        if (entities != null) {
            if (other.entities == null) return false
            if (!entities.contentEquals(other.entities)) return false
        } else if (other.entities != null) return false
        if (captionEntities != null) {
            if (other.captionEntities == null) return false
            if (!captionEntities.contentEquals(other.captionEntities)) return false
        } else if (other.captionEntities != null) return false
        if (audio != other.audio) return false
        if (document != other.document) return false
        if (animation != other.animation) return false
        if (game != other.game) return false
        if (photo != null) {
            if (other.photo == null) return false
            if (!photo.contentEquals(other.photo)) return false
        } else if (other.photo != null) return false
        if (sticker != other.sticker) return false
        if (video != other.video) return false
        if (voice != other.voice) return false
        if (videoNote != other.videoNote) return false
        if (caption != other.caption) return false
        if (contact != other.contact) return false
        if (location != other.location) return false
        if (venue != other.venue) return false
        if (poll != other.poll) return false
        if (newChatMembers != null) {
            if (other.newChatMembers == null) return false
            if (!newChatMembers.contentEquals(other.newChatMembers)) return false
        } else if (other.newChatMembers != null) return false
        if (leftChatMember != other.leftChatMember) return false
        if (newChatTitle != other.newChatTitle) return false
        if (newChatPhoto != null) {
            if (other.newChatPhoto == null) return false
            if (!newChatPhoto.contentEquals(other.newChatPhoto)) return false
        } else if (other.newChatPhoto != null) return false
        if (deleteChatPhoto != other.deleteChatPhoto) return false
        if (groupChatCreated != other.groupChatCreated) return false
        if (supergroupChatCreated != other.supergroupChatCreated) return false
        if (channelChatCreated != other.channelChatCreated) return false
        if (migrateToChatId != other.migrateToChatId) return false
        if (migrateFromChatId != other.migrateFromChatId) return false
        if (pinnedMessage != other.pinnedMessage) return false
        if (invoice != other.invoice) return false
        if (successfulPayment != other.successfulPayment) return false
        if (connectedWebsite != other.connectedWebsite) return false
        if (passportData != other.passportData) return false
        if (replyMarkup != other.replyMarkup) return false

        return true
    }

    override fun hashCode(): Int {
        var result = messageId
        result = 31 * result + (from?.hashCode() ?: 0)
        result = 31 * result + date
        result = 31 * result + chat.hashCode()
        result = 31 * result + (forwardFrom?.hashCode() ?: 0)
        result = 31 * result + (forwardFromChat?.hashCode() ?: 0)
        result = 31 * result + (forwardFromMessageId ?: 0)
        result = 31 * result + (forwardSignature?.hashCode() ?: 0)
        result = 31 * result + (forwardSenderName?.hashCode() ?: 0)
        result = 31 * result + (forwardDate ?: 0)
        result = 31 * result + (replyToMessage?.hashCode() ?: 0)
        result = 31 * result + (editDate ?: 0)
        result = 31 * result + (mediaGroupId?.hashCode() ?: 0)
        result = 31 * result + (authorSignature?.hashCode() ?: 0)
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + (entities?.contentHashCode() ?: 0)
        result = 31 * result + (captionEntities?.contentHashCode() ?: 0)
        result = 31 * result + (audio?.hashCode() ?: 0)
        result = 31 * result + (document?.hashCode() ?: 0)
        result = 31 * result + (animation?.hashCode() ?: 0)
        result = 31 * result + (game?.hashCode() ?: 0)
        result = 31 * result + (photo?.contentHashCode() ?: 0)
        result = 31 * result + (sticker?.hashCode() ?: 0)
        result = 31 * result + (video?.hashCode() ?: 0)
        result = 31 * result + (voice?.hashCode() ?: 0)
        result = 31 * result + (videoNote?.hashCode() ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        result = 31 * result + (contact?.hashCode() ?: 0)
        result = 31 * result + (location?.hashCode() ?: 0)
        result = 31 * result + (venue?.hashCode() ?: 0)
        result = 31 * result + (poll?.hashCode() ?: 0)
        result = 31 * result + (newChatMembers?.contentHashCode() ?: 0)
        result = 31 * result + (leftChatMember?.hashCode() ?: 0)
        result = 31 * result + (newChatTitle?.hashCode() ?: 0)
        result = 31 * result + (newChatPhoto?.contentHashCode() ?: 0)
        result = 31 * result + (deleteChatPhoto?.hashCode() ?: 0)
        result = 31 * result + (groupChatCreated?.hashCode() ?: 0)
        result = 31 * result + (supergroupChatCreated?.hashCode() ?: 0)
        result = 31 * result + (channelChatCreated?.hashCode() ?: 0)
        result = 31 * result + (migrateToChatId ?: 0)
        result = 31 * result + (migrateFromChatId ?: 0)
        result = 31 * result + (pinnedMessage?.hashCode() ?: 0)
        result = 31 * result + (invoice?.hashCode() ?: 0)
        result = 31 * result + (successfulPayment?.hashCode() ?: 0)
        result = 31 * result + (connectedWebsite?.hashCode() ?: 0)
        result = 31 * result + (passportData?.hashCode() ?: 0)
        result = 31 * result + (replyMarkup?.hashCode() ?: 0)
        return result
    }
}