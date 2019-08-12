@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Message

/**
 * Use this method to send information about a venue. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[latitude] Latitude of the venue
 * @param[longitude] Longitude of the venue
 * @param[title] Name of the venue
 * @param[address] Address of the venue
 * @param[foursquareId] Foursquare identifier of the venue
 * @param[foursquareType] Foursquare type of the venue, if known. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendVenue(
    chatId: String,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    foursquareType: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendVenue",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("title", title),
        Pair("address", address),
        Pair("foursquare_id", foursquareId),
        Pair("foursquare_type", foursquareType),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

fun ApiContext.sendVenue(
    chatId: String,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    foursquareType: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: Message?) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendVenue",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("title", title),
        Pair("address", address),
        Pair("foursquare_id", foursquareId),
        Pair("foursquare_type", foursquareType),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback
)

suspend fun ApiContext.sendVenueAwait(
    chatId: String,
    latitude: Double,
    longitude: Double,
    title: String,
    address: String,
    foursquareId: String? = null,
    foursquareType: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendVenue",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("title", title),
        Pair("address", address),
        Pair("foursquare_id", foursquareId),
        Pair("foursquare_type", foursquareType),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)