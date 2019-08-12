@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Message

/**
 * Use this method to send phone contacts. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[phoneNumber] Contact's phone number
 * @param[firstName] Contact's first name
 * @param[lastName] Contact's last name
 * @param[vcard] Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove keyboard or to force a reply from the user.
 */
fun ApiContext.sendContact(
    chatId: String,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    vcard: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendContact",
    listOf(
        Pair("chat_id", chatId),
        Pair("phone_number", phoneNumber),
        Pair("first_name", firstName),
        Pair("last_name", lastName),
        Pair("vcard", vcard),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendContact(
    chatId: String,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    vcard: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: Message?) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendContact",
    listOf(
        Pair("chat_id", chatId),
        Pair("phone_number", phoneNumber),
        Pair("first_name", firstName),
        Pair("last_name", lastName),
        Pair("vcard", vcard),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendContactAwait(
    chatId: String,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    vcard: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendContact",
    listOf(
        Pair("chat_id", chatId),
        Pair("phone_number", phoneNumber),
        Pair("first_name", firstName),
        Pair("last_name", lastName),
        Pair("vcard", vcard),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)