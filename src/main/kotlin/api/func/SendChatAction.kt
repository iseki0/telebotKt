@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.Future

/**
 * Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns *True* on success.
 * >  Example: The [ImageBot](https://t.me/imagebot) needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use [sendChatAction][sendChatAction] with *action* = *upload_photo*. The user will see a “sending photo” status for the bot.
 * We only recommend using this method when a response from the bot will take a **noticeable** amount of time to arrive.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format `@channelusername`)
 * @param[action] Type of action to broadcast. Choose one, depending on what the user is about to receive: *typing* for [text messages][sendMessage], *upload_photo* for [photos][sendPhoto], *record_video* or *upload_video* for [videos][sendVideo], *record_audio* or *upload_audio* for [audio files][sendAudio], *upload_document* for [general files][sendDocument], *find_location* for [location data][sendLocation], *record_video_note* or *upload_video_note* for [video notes][sendVideoNote].
 */
fun ApiContext.sendChatAction(
    chatId: String,
    action: ChatActionType
): Future<Boolean?> = sendRequest<Boolean?>("sendChatAction", listOf(Pair("chat_id", chatId), Pair("action", action)))

fun ApiContext.sendChatAction(
    chatId: String,
    action: ChatActionType,
    callback: (result: Boolean?) -> Unit
): ApiContext =
    sendRequestCallback<Boolean?>("sendChatAction", listOf(Pair("chat_id", chatId), Pair("action", action)), callback)

suspend fun ApiContext.sendChatActionAwait(
    chatId: String,
    action: ChatActionType
): Boolean? = sendRequestAwait<Boolean?>("sendChatAction", listOf(Pair("chat_id", chatId), Pair("action", action)))