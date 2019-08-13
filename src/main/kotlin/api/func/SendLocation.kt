@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to send point on the map. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[latitude] Latitude of the location
 * @param[longitude] Longitude of the location
 * @param[livePeriod] Period in seconds for which the location will be updated (see [Live Locations](https://telegram.org/blog/live-locations), should be between 60 and 86400.
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun ApiContext.sendLocation(
    chatId: String,
    latitude: Double,
    longitude: Double,
    livePeriod: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = sendRequest<Message?>(
    "sendLocation",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("live_period", livePeriod),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})

fun ApiContext.sendLocation(
    chatId: String,
    latitude: Double,
    longitude: Double,
    livePeriod: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null,
    callback: (result: AsyncResult<Message?>) -> Unit
): ApiContext = sendRequestCallback<Message?>(
    "sendLocation",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("live_period", livePeriod),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    callback,
    object : TypeReference<Message> {})

suspend fun ApiContext.sendLocationAwait(
    chatId: String,
    latitude: Double,
    longitude: Double,
    livePeriod: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Message? = sendRequestAwait<Message?>(
    "sendLocation",
    listOf(
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("live_period", livePeriod),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    ),
    object : TypeReference<Message> {})