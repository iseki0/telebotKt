package api

import api.type.*
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty


data class GetUpdatesResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: List<Update>?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetWebhookResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendMessageResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class ForwardMessageResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendPhotoResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendAudioResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendDocumentResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendVideoResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendAnimationResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendVoiceResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendVideoNoteResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendMediaGroupResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: List<Message>?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendLocationResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageLiveLocationResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageLiveLocationResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class StopMessageLiveLocationResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class StopMessageLiveLocationResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendVenueResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendContactResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendPollResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendChatActionResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetUserProfilePhotosResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: UserProfilePhotos?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetFileResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: File?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class KickChatMemberResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class UnbanChatMemberResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class RestrictChatMemberResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class PromoteChatMemberResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetChatPermissionsResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class ExportChatInviteLinkResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: String?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetChatPhotoResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class DeleteChatPhotoResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetChatTitleResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetChatDescriptionResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class PinChatMessageResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class UnpinChatMessageResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class LeaveChatResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetChatResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Chat?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetChatAdministratorsResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: List<ChatMember>?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetChatMembersCountResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Int?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetChatMemberResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: ChatMember?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetChatStickerSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class DeleteChatStickerSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class AnswerCallbackQueryResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageTextResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageTextResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageCaptionResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageCaptionResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageMediaResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageMediaResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageReplyMarkupResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class EditMessageReplyMarkupResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType


data class StopPollResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Poll?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class DeleteMessageResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendStickerResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetStickerSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: StickerSet?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class UploadStickerFileResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: File?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class CreateNewStickerSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class AddStickerToSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetStickerPositionInSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class DeleteStickerFromSetResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class AnswerInlineQueryResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendInvoiceResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class AnswerShippingQueryResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class AnswerPreCheckoutQueryResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetPassportDataErrorsResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SendGameResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetGameScoreResultMessage @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Message?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class SetGameScoreResultBoolean @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: Boolean?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType

data class GetGameHighScoresResult @JsonCreator constructor(
    @JsonProperty("ok") override val ok: Boolean,
    @JsonProperty("result") val result: List<GameHighScore>?,
    @JsonProperty("error_code") override val errorCode: Int?,
    @JsonProperty("description") override val description: String?
) : ResultType
