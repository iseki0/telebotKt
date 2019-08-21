@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
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
 * @param[replyToMessage] *Optional*. For replies, the original message. Note that the Message object in this field will not contain further *reply_to_message* fields even if it itself is a reply.
 * @param[editDate] *Optional*. Date the message was last edited in Unix time
 * @param[mediaGroupId] *Optional*. The unique identifier of a media message group this message belongs to
 * @param[authorSignature] *Optional*. Signature of the post author for messages in channels
 * @param[text] *Optional*. For text messages, the actual UTF-8 text of the message, 0-4096 characters.
 * @param[entities] *Optional*. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
 * @param[captionEntities] *Optional*. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
 * @param[audio] *Optional*. Message is an audio file, information about the file
 * @param[document] *Optional*. Message is a general file, information about the file
 * @param[animation] *Optional*. Message is an animation, information about the animation. For backward compatibility, when this field is set, the *document* field will also be set
 * @param[game] *Optional*. Message is a game, information about the game. [More about games »](https://core.telegram.org#games)
 * @param[photo] *Optional*. Message is a photo, available sizes of the photo
 * @param[sticker] *Optional*. Message is a sticker, information about the sticker
 * @param[video] *Optional*. Message is a video, information about the video
 * @param[voice] *Optional*. Message is a voice message, information about the file
 * @param[videoNote] *Optional*. Message is a [video note](https://telegram.org/blog/video-messages-and-telescope), information about the video message
 * @param[caption] *Optional*. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
 * @param[contact] *Optional*. Message is a shared contact, information about the contact
 * @param[location] *Optional*. Message is a shared location, information about the location
 * @param[venue] *Optional*. Message is a venue, information about the venue
 * @param[poll] *Optional*. Message is a native poll, information about the poll
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
 * @param[pinnedMessage] *Optional*. Specified message was pinned. Note that the Message object in this field will not contain further *reply_to_message* fields even if it is itself a reply.
 * @param[invoice] *Optional*. Message is an invoice for a [payment](https://core.telegram.org#payments), information about the invoice. [More about payments »](https://core.telegram.org#payments)
 * @param[successfulPayment] *Optional*. Message is a service message about a successful payment, information about the payment. [More about payments »](https://core.telegram.org#payments)
 * @param[connectedWebsite] *Optional*. The domain name of the website on which the user has logged in. [More about Telegram Login »](https://core.telegram.org/widgets/login)
 * @param[passportData] *Optional*. Telegram Passport data
 * @param[replyMarkup] *Optional*. Inline keyboard attached to the message. `login_url` buttons are represented as ordinary `url` buttons.
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Message @JsonCreator constructor(
    @get:JsonProperty("message_id")
    @JsonProperty("message_id")
    val messageId: Int,
    @get:JsonProperty("from")
    @JsonProperty("from")
    val from: User? = null,
    @get:JsonProperty("date")
    @JsonProperty("date")
    val date: Int,
    @get:JsonProperty("chat")
    @JsonProperty("chat")
    val chat: Chat,
    @get:JsonProperty("forward_from")
    @JsonProperty("forward_from")
    val forwardFrom: User? = null,
    @get:JsonProperty("forward_from_chat")
    @JsonProperty("forward_from_chat")
    val forwardFromChat: Chat? = null,
    @get:JsonProperty("forward_from_message_id")
    @JsonProperty("forward_from_message_id")
    val forwardFromMessageId: Int? = null,
    @get:JsonProperty("forward_signature")
    @JsonProperty("forward_signature")
    val forwardSignature: String? = null,
    @get:JsonProperty("forward_sender_name")
    @JsonProperty("forward_sender_name")
    val forwardSenderName: String? = null,
    @get:JsonProperty("forward_date")
    @JsonProperty("forward_date")
    val forwardDate: Int? = null,
    @get:JsonProperty("reply_to_message")
    @JsonProperty("reply_to_message")
    val replyToMessage: Message? = null,
    @get:JsonProperty("edit_date")
    @JsonProperty("edit_date")
    val editDate: Int? = null,
    @get:JsonProperty("media_group_id")
    @JsonProperty("media_group_id")
    val mediaGroupId: String? = null,
    @get:JsonProperty("author_signature")
    @JsonProperty("author_signature")
    val authorSignature: String? = null,
    @get:JsonProperty("text")
    @JsonProperty("text")
    val text: String? = null,
    @get:JsonProperty("entities")
    @JsonProperty("entities")
    val entities: List<MessageEntity>? = null,
    @get:JsonProperty("caption_entities")
    @JsonProperty("caption_entities")
    val captionEntities: List<MessageEntity>? = null,
    @get:JsonProperty("audio")
    @JsonProperty("audio")
    val audio: Audio? = null,
    @get:JsonProperty("document")
    @JsonProperty("document")
    val document: Document? = null,
    @get:JsonProperty("animation")
    @JsonProperty("animation")
    val animation: Animation? = null,
    @get:JsonProperty("game")
    @JsonProperty("game")
    val game: Game? = null,
    @get:JsonProperty("photo")
    @JsonProperty("photo")
    val photo: List<PhotoSize>? = null,
    @get:JsonProperty("sticker")
    @JsonProperty("sticker")
    val sticker: Sticker? = null,
    @get:JsonProperty("video")
    @JsonProperty("video")
    val video: Video? = null,
    @get:JsonProperty("voice")
    @JsonProperty("voice")
    val voice: Voice? = null,
    @get:JsonProperty("video_note")
    @JsonProperty("video_note")
    val videoNote: VideoNote? = null,
    @get:JsonProperty("caption")
    @JsonProperty("caption")
    val caption: String? = null,
    @get:JsonProperty("contact")
    @JsonProperty("contact")
    val contact: Contact? = null,
    @get:JsonProperty("location")
    @JsonProperty("location")
    val location: Location? = null,
    @get:JsonProperty("venue")
    @JsonProperty("venue")
    val venue: Venue? = null,
    @get:JsonProperty("poll")
    @JsonProperty("poll")
    val poll: Poll? = null,
    @get:JsonProperty("new_chat_members")
    @JsonProperty("new_chat_members")
    val newChatMembers: List<User>? = null,
    @get:JsonProperty("left_chat_member")
    @JsonProperty("left_chat_member")
    val leftChatMember: User? = null,
    @get:JsonProperty("new_chat_title")
    @JsonProperty("new_chat_title")
    val newChatTitle: String? = null,
    @get:JsonProperty("new_chat_photo")
    @JsonProperty("new_chat_photo")
    val newChatPhoto: List<PhotoSize>? = null,
    @get:JsonProperty("delete_chat_photo")
    @JsonProperty("delete_chat_photo")
    val deleteChatPhoto: Boolean? = null,
    @get:JsonProperty("group_chat_created")
    @JsonProperty("group_chat_created")
    val groupChatCreated: Boolean? = null,
    @get:JsonProperty("supergroup_chat_created")
    @JsonProperty("supergroup_chat_created")
    val supergroupChatCreated: Boolean? = null,
    @get:JsonProperty("channel_chat_created")
    @JsonProperty("channel_chat_created")
    val channelChatCreated: Boolean? = null,
    @get:JsonProperty("migrate_to_chat_id")
    @JsonProperty("migrate_to_chat_id")
    val migrateToChatId: Long? = null,
    @get:JsonProperty("migrate_from_chat_id")
    @JsonProperty("migrate_from_chat_id")
    val migrateFromChatId: Long? = null,
    @get:JsonProperty("pinned_message")
    @JsonProperty("pinned_message")
    val pinnedMessage: Message? = null,
    @get:JsonProperty("invoice")
    @JsonProperty("invoice")
    val invoice: Invoice? = null,
    @get:JsonProperty("successful_payment")
    @JsonProperty("successful_payment")
    val successfulPayment: SuccessfulPayment? = null,
    @get:JsonProperty("connected_website")
    @JsonProperty("connected_website")
    val connectedWebsite: String? = null,
    @get:JsonProperty("passport_data")
    @JsonProperty("passport_data")
    val passportData: PassportData? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null
) : UpdateMsg