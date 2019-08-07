@file:Suppress("unused", "KDocUnresolvedReference")

import io.vertx.core.Future
import types.*


/**
 * Use this method to receive incoming updates using long polling ([wiki](http://en.wikipedia.org/wiki/Push_technology#Long_polling)). An Array of [Update][Update] objects is returned.
 * **Notes** \
 * **1.** This method will not work if an outgoing webhook is set up. \
 * **2.** In order to avoid getting duplicate updates, recalculate *offset* after each server response.
 *
 * @param[offset] Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as [getUpdates][getUpdates] is called with an *offset* higher than its *update_id*. The negative offset can be specified to retrieve updates starting from *-offset* update from the end of the updates queue. All previous updates will forgotten.
 * @param[limit] Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100.
 * @param[timeout] Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * @param[allowedUpdates] List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See [Update][Update] for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used. \
 * Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 */
fun BotContext.getUpdates(
    offset: Int? = null,
    limit: Int? = null,
    timeout: Int? = null,
    allowedUpdates: Array<AllowedUpdateType>? = null
): Future<Array<Update>?> = awslByArray(
    genBotRequest(
        "getUpdates",
        Pair("offset", offset),
        Pair("limit", limit),
        Pair("timeout", timeout),
        Pair("allowed_updates", allowedUpdates)
    )
)

/**
 * Use this method to specify a url and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url, containing a JSON-serialized [Update][Update]. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns *True* on success.
 * If you'd like to make sure that the Webhook request comes from Telegram, we recommend using a secret path in the URL, e.g.  `https://www.example.com/<token>` . Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
 * **Notes** \
 * **1.** You will not be able to receive updates using [getUpdates][getUpdates] for as long as an outgoing webhook is set up. \
 * **2.** To use a self-signed certificate, you need to upload your [public key certificate](https://core.telegram.org/bots/self-signed) using *certificate* parameter. Please upload as InputFile, sending a String will not work. \
 * **3.** Ports currently supported *for Webhooks*: **443, 80, 88, 8443**. **NEW!** If you're having any trouble setting up webhooks, please check out this [amazing guide to Webhooks](https://core.telegram.org/bots/webhooks).
 *
 * @param[url] HTTPS url to send updates to. Use an empty string to remove webhook integration
 * @param[certificate] Upload your public key certificate so that the root certificate in use can be checked. See our [self-signed guide](https://core.telegram.org/bots/self-signed) for details.
 * @param[maxConnections] Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to *40*. Use lower values to limit the load on your bot‘s server, and higher values to increase your bot’s throughput.
 * @param[allowedUpdates] List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See [Update][Update] for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used. \
 * Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
 */
fun BotContext.setWebhook(
    url: String,
    certificate: InputFile? = null,
    maxConnections: Int? = null,
    allowedUpdates: Array<AllowedUpdateType>? = null
): Future<Boolean?> =
    awsl(
        genBotRequest(
            "setWebhook",
            Pair("url", url),
            Pair("certificate", certificate),
            Pair("max_connections", maxConnections),
            Pair("allowed_updates", allowedUpdates)
        )
    )

/**
 * Use this method to remove webhook integration if you decide to switch back to [getUpdates][getUpdates]. Returns *True* on success. Requires no parameters.
 *

 */
fun BotContext.deleteWebhook(): Future<Boolean?> = awsl(genBotRequest("deleteWebhook"))

/**
 * Use this method to get current webhook status. Requires no parameters. On success, returns a [WebhookInfo][WebhookInfo] object. If the bot is using [getUpdates][getUpdates], will return an object with the *url* field empty.
 *

 */
fun BotContext.getWebhookInfo(): Future<WebhookInfo?> = awsl(genBotRequest("getWebhookInfo"))

/**
 * A simple method for testing your bot's auth token. Requires no parameters. Returns basic information about the bot in form of a [User][User] object.
 *

 */
fun BotContext.getMe(): Future<User?> = awsl(genBotRequest("getMe"))

/**
 * Use this method to send text messages. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[text] Text of the message to be sent
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in your bot's message.
 * @param[disableWebPagePreview] Disables link previews for links in this message
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendMessage(
    chatId: String,
    text: String,
    parseMode: ParseMode? = null,
    disableWebPagePreview: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendMessage",
        Pair("chat_id", chatId),
        Pair("text", text),
        Pair("parse_mode", parseMode),
        Pair("disable_web_page_preview", disableWebPagePreview),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to forward messages of any kind. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[fromChatId] Unique identifier for the chat where the original message was sent (or channel username in the format  `@channelusername` )
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[messageId] Message identifier in the chat specified in *from_chat_id*
 */
fun BotContext.forwardMessage(
    chatId: String,
    fromChatId: Int,
    disableNotification: Boolean? = null,
    messageId: Int
): Future<Message?> =
    awsl(
        genBotRequest(
            "forwardMessage",
            Pair("chat_id", chatId),
            Pair("from_chat_id", fromChatId),
            Pair("disable_notification", disableNotification),
            Pair("message_id", messageId)
        )
    )

/**
 * Use this method to send photos. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[photo] Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[caption] Photo caption (may also be used when resending photos by *file_id*), 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendPhoto(
    chatId: String,
    photo: String,
    caption: String? = null,
    parseMode: ParseMode? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendPhoto",
        Pair("chat_id", chatId),
        Pair("photo", photo),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .mp3 format. On success, the sent [Message][Message] is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
 * For sending voice messages, use the [sendVoice][sendVoice] method instead.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[audio] Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[caption] Audio caption, 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[duration] Duration of the audio in seconds
 * @param[performer] Performer
 * @param[title] Track name
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendAudio(
    chatId: String,
    audio: String,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    performer: String? = null,
    title: String? = null,
    thumb: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendAudio",
        Pair("chat_id", chatId),
        Pair("audio", audio),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("performer", performer),
        Pair("title", title),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send general files. On success, the sent [Message][Message] is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[document] File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[caption] Document caption (may also be used when resending documents by *file_id*), 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendDocument(
    chatId: String,
    document: String,
    thumb: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendDocument",
        Pair("chat_id", chatId),
        Pair("document", document),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as [Document][Document]). On success, the sent [Message][Message] is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[video] Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[duration] Duration of sent video in seconds
 * @param[width] Video width
 * @param[height] Video height
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[caption] Video caption (may also be used when resending videos by *file_id*), 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[supportsStreaming] Pass *True*, if the uploaded video is suitable for streaming
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendVideo(
    chatId: String,
    video: String,
    duration: Int? = null,
    width: Int? = null,
    height: Int? = null,
    thumb: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    supportsStreaming: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendVideo",
        Pair("chat_id", chatId),
        Pair("video", video),
        Pair("duration", duration),
        Pair("width", width),
        Pair("height", height),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("supports_streaming", supportsStreaming),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent [Message][Message] is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[animation] Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[duration] Duration of sent animation in seconds
 * @param[width] Animation width
 * @param[height] Animation height
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[caption] Animation caption (may also be used when resending animation by *file_id*), 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendAnimation(
    chatId: String,
    animation: String,
    duration: Int? = null,
    width: Int? = null,
    height: Int? = null,
    thumb: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendAnimation",
        Pair("chat_id", chatId),
        Pair("animation", animation),
        Pair("duration", duration),
        Pair("width", width),
        Pair("height", height),
        Pair("thumb", thumb),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .ogg file encoded with OPUS (other formats may be sent as [Audio][Audio] or [Document][Document]). On success, the sent [Message][Message] is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[voice] Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[caption] Voice message caption, 0-1024 characters
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[duration] Duration of the voice message in seconds
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendVoice(
    chatId: String,
    voice: String,
    caption: String? = null,
    parseMode: ParseMode? = null,
    duration: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendVoice",
        Pair("chat_id", chatId),
        Pair("voice", voice),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("duration", duration),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * As of [v.4.0](https://telegram.org/blog/video-messages-and-telescope), Telegram clients support rounded square mp4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[videoNote] Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. [More info on Sending Files »][Sending files]. Sending video notes by a URL is currently unsupported
 * @param[duration] Duration of sent video in seconds
 * @param[length] Video width and height, i.e. diameter of the video message
 * @param[thumb] Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>. [More info on Sending Files »][Sending files]
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendVideoNote(
    chatId: String,
    videoNote: String,
    duration: Int? = null,
    length: Int? = null,
    thumb: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendVideoNote",
        Pair("chat_id", chatId),
        Pair("video_note", videoNote),
        Pair("duration", duration),
        Pair("length", length),
        Pair("thumb", thumb),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send a group of photos or videos as an album. On success, an array of the sent [Messages][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[media] A JSON-serialized array describing photos and videos to be sent, must include 2–10 items
 * @param[disableNotification] Sends the messages [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the messages are a reply, ID of the original message
 */
fun BotContext.sendMediaGroup(
    chatId: String,
    media: MediaGroupable,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null
): Future<Array<Message>?> = awslByArray(
    genBotRequest(
        "sendMediaGroup",
        Pair("chat_id", chatId),
        Pair("media", media),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId)
    )
)

/**
 * Use this method to send point on the map. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[latitude] Latitude of the location
 * @param[longitude] Longitude of the location
 * @param[livePeriod] Period in seconds for which the location will be updated (see [Live Locations](https://telegram.org/blog/live-locations), should be between 60 and 86400.
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendLocation(
    chatId: String,
    latitude: Double,
    longitude: Double,
    livePeriod: Int? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendLocation",
        Pair("chat_id", chatId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("live_period", livePeriod),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to edit live location messages. A location can be edited until its *live_period* expires or editing is explicitly disabled by a call to [stopMessageLiveLocation][stopMessageLiveLocation]. On success, if the edited message was sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[latitude] Latitude of new location
 * @param[longitude] Longitude of new location
 * @param[replyMarkup] A JSON-serialized object for a new [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.editMessageLiveLocation(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    latitude: Double,
    longitude: Double,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "editMessageLiveLocation",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("latitude", latitude),
        Pair("longitude", longitude),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to stop updating a live location message before *live_period* expires. On success, if the message was sent by the bot, the sent [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message with live location to stop
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[replyMarkup] A JSON-serialized object for a new [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.stopMessageLiveLocation(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "stopMessageLiveLocation",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to send information about a venue. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
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
fun BotContext.sendVenue(
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
): Future<Message?> = awsl(
    genBotRequest(
        "sendVenue",
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

/**
 * Use this method to send phone contacts. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[phoneNumber] Contact's phone number
 * @param[firstName] Contact's first name
 * @param[lastName] Contact's last name
 * @param[vcard] Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove keyboard or to force a reply from the user.
 */
fun BotContext.sendContact(
    chatId: String,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    vcard: String? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendContact",
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

/**
 * Use this method to send a native poll. A native poll can't be sent to a private chat. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` ). A native poll can't be sent to a private chat.
 * @param[question] Poll question, 1-255 characters
 * @param[options] List of answer options, 2-10 strings 1-100 characters each
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendPoll(
    chatId: String,
    question: String,
    options: Array<String>,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendPoll",
        Pair("chat_id", chatId),
        Pair("question", question),
        Pair("options", options),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns *True* on success.
 * Example: The [ImageBot](https://t.me/imagebot) needs some time to process a request and upload the image. Instead of sending a text message along the lines of “Retrieving image, please wait…”, the bot may use [sendChatAction][sendChatAction] with *action* = *upload_photo*. The user will see a “sending photo” status for the bot.
 * We only recommend using this method when a response from the bot will take a **noticeable** amount of time to arrive.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[action] Type of action to broadcast. Choose one, depending on what the user is about to receive: *typing* for [text messages][sendMessage], *upload_photo* for [photos][sendPhoto], *record_video* or *upload_video* for [videos][sendVideo], *record_audio* or *upload_audio* for [audio files][sendAudio], *upload_document* for [general files][sendDocument], *find_location* for [location data][sendLocation], *record_video_note* or *upload_video_note* for [video notes][sendVideoNote].
 */
fun BotContext.sendChatAction(chatId: String, action: String): Future<Boolean?> =
    awsl(genBotRequest("sendChatAction", Pair("chat_id", chatId), Pair("action", action)))

/**
 * Use this method to get a list of profile pictures for a user. Returns a [UserProfilePhotos][UserProfilePhotos] object.
 *
 * @param[userId] Unique identifier of the target user
 * @param[offset] Sequential number of the first photo to be returned. By default, all photos are returned.
 * @param[limit] Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
 */
fun BotContext.getUserProfilePhotos(userId: Int, offset: Int? = null, limit: Int?): Future<UserProfilePhotos?> =
    awsl(genBotRequest("getUserProfilePhotos", Pair("user_id", userId), Pair("offset", offset), Pair("limit", limit)))

/**
 * Use this method to get basic info about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a [File][File] object is returned. The file can then be downloaded via the link  `https://api.telegram.org/file/bot<token>/<file_path>` , where  `<file_path>`  is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling [getFile][getFile] again.
 * **Note:** This function may not preserve the original file name and MIME type. You should save the file's MIME type and name (if available) when the File object is received.
 *
 * @param[fileId] File identifier to get info about
 */
fun BotContext.getFile(fileId: String): Future<File?> = awsl(genBotRequest("getFile", Pair("file_id", fileId)))

/**
 * Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless [unbanned][unbanChatMember] first. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group. Otherwise members may only be removed by the group's creator or by the member that added them.
 *
 * @param[chatId] Unique identifier for the target group or username of the target supergroup or channel (in the format  `@channelusername` )
 * @param[userId] Unique identifier of the target user
 * @param[untilDate] Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
 */
fun BotContext.kickChatMember(chatId: String, userId: Int, untilDate: Int?): Future<Boolean?> =
    awsl(
        genBotRequest(
            "kickChatMember",
            Pair("chat_id", chatId),
            Pair("user_id", userId),
            Pair("until_date", untilDate)
        )
    )

/**
 * Use this method to unban a previously kicked user in a supergroup or channel. The user will **not** return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target group or username of the target supergroup or channel (in the format  `@username` )
 * @param[userId] Unique identifier of the target user
 */
fun BotContext.unbanChatMember(chatId: String, userId: Int): Future<Boolean?> =
    awsl(genBotRequest("unbanChatMember", Pair("chat_id", chatId), Pair("user_id", userId)))

/**
 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights. Pass *True* for all boolean parameters to lift restrictions from a user. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format  `@supergroupusername` )
 * @param[userId] Unique identifier of the target user
 * @param[permissions] New user permissions
 * @param[untilDate] Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
 */
fun BotContext.restrictChatMember(
    chatId: String,
    userId: Int,
    permissions: ChatPermissions,
    untilDate: Int? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "restrictChatMember",
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("permissions", permissions),
        Pair("until_date", untilDate)
    )
)

/**
 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Pass *False* for all boolean parameters to demote a user. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[userId] Unique identifier of the target user
 * @param[canChangeInfo] Pass True, if the administrator can change chat title, photo and other settings
 * @param[canPostMessages] Pass True, if the administrator can create channel posts, channels only
 * @param[canEditMessages] Pass True, if the administrator can edit messages of other users and can pin messages, channels only
 * @param[canDeleteMessages] Pass True, if the administrator can delete messages of other users
 * @param[canInviteUsers] Pass True, if the administrator can invite new users to the chat
 * @param[canRestrictMembers] Pass True, if the administrator can restrict, ban or unban chat members
 * @param[canPinMessages] Pass True, if the administrator can pin messages, supergroups only
 * @param[canPromoteMembers] Pass True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
 */
fun BotContext.promoteChatMember(
    chatId: String,
    userId: Int,
    canChangeInfo: Boolean? = null,
    canPostMessages: Boolean? = null,
    canEditMessages: Boolean? = null,
    canDeleteMessages: Boolean? = null,
    canInviteUsers: Boolean? = null,
    canRestrictMembers: Boolean? = null,
    canPinMessages: Boolean? = null,
    canPromoteMembers: Boolean? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "promoteChatMember",
        Pair("chat_id", chatId),
        Pair("user_id", userId),
        Pair("can_change_info", canChangeInfo),
        Pair("can_post_messages", canPostMessages),
        Pair("can_edit_messages", canEditMessages),
        Pair("can_delete_messages", canDeleteMessages),
        Pair("can_invite_users", canInviteUsers),
        Pair("can_restrict_members", canRestrictMembers),
        Pair("can_pin_messages", canPinMessages),
        Pair("can_promote_members", canPromoteMembers)
    )
)


/**
 * Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the *can_restrict_members* admin rights. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format `@supergroupusername`)
 * @param[permissions] New default chat permissions
 */
fun BotContext.setChatPermissions(chatId: String, permissions: ChatPermissions): Future<Boolean?> =
    awsl(genBotRequest("setChatPermissions", Pair("chat_id", chatId), Pair("permissions", permissions)))

/**
 * Use this method to generate a new invite link for a chat; any previously generated link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns the new invite link as *String* on success.
 * Note: Each administrator in a chat generates their own invite links. Bots can't use invite links generated by other administrators. If you want your bot to work with invite links, it will need to generate its own link using [exportChatInviteLink][exportChatInviteLink] – after this the link will become available to the bot via the [getChat][getChat] method. If your bot needs to generate a new invite link replacing its previous one, use [exportChatInviteLink][exportChatInviteLink] again.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 */
fun BotContext.exportChatInviteLink(chatId: String): Future<String?> =
    awsl(genBotRequest("exportChatInviteLink", Pair("chat_id", chatId)))

/**
 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[photo] New chat photo, uploaded using multipart/form-data
 */
fun BotContext.setChatPhoto(chatId: String, photo: InputFile): Future<Boolean?> =
    awsl(genBotRequest("setChatPhoto", Pair("chat_id", chatId), Pair("photo", photo)))

/**
 * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 */
fun BotContext.deleteChatPhoto(chatId: String): Future<Boolean?> =
    awsl(genBotRequest("deleteChatPhoto", Pair("chat_id", chatId)))

/**
 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 * Note: In regular groups (non-supergroups), this method will only work if the ‘All Members Are Admins’ setting is off in the target group.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[title] New chat title, 1-255 characters
 */
fun BotContext.setChatTitle(chatId: String, title: String): Future<Boolean?> =
    awsl(genBotRequest("setChatTitle", Pair("chat_id", chatId), Pair("title", title)))

/**
 * Use this method to change the description of a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[description] New chat description, 0-255 characters
 */
fun BotContext.setChatDescription(chatId: String, description: String?): Future<Boolean?> =
    awsl(genBotRequest("setChatDescription", Pair("chat_id", chatId), Pair("description", description)))

/**
 * Use this method to pin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Identifier of a message to pin
 * @param[disableNotification] Pass *True*, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
 */
fun BotContext.pinChatMessage(chatId: String, messageId: Int, disableNotification: Boolean?): Future<Boolean?> = awsl(
    genBotRequest(
        "pinChatMessage",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("disable_notification", disableNotification)
    )
)

/**
 * Use this method to unpin a message in a group, a supergroup, or a channel. The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 */
fun BotContext.unpinChatMessage(chatId: String): Future<Boolean?> =
    awsl(genBotRequest("unpinChatMessage", Pair("chat_id", chatId)))

/**
 * Use this method for your bot to leave a group, supergroup or channel. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format  `@channelusername` )
 */
fun BotContext.leaveChat(chatId: String): Future<Boolean?> = awsl(genBotRequest("leaveChat", Pair("chat_id", chatId)))

/**
 * Use this method to get up to date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a [Chat][Chat] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format  `@channelusername` )
 */
fun BotContext.getChat(chatId: String): Future<Chat?> = awsl(genBotRequest("getChat", Pair("chat_id", chatId)))

/**
 * Use this method to get a list of administrators in a chat. On success, returns an Array of [ChatMember][ChatMember] objects that contains information about all chat administrators except other bots. If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format  `@channelusername` )
 */
fun BotContext.getChatAdministrators(chatId: String): Future<Array<ChatMember>?> =
    awslByArray(genBotRequest("getChatAdministrators", Pair("chat_id", chatId)))

/**
 * Use this method to get the number of members in a chat. Returns *Int* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format  `@channelusername` )
 */
fun BotContext.getChatMembersCount(chatId: String): Future<Int?> =
    awsl(genBotRequest("getChatMembersCount", Pair("chat_id", chatId)))

/**
 * Use this method to get information about a member of a chat. Returns a [ChatMember][ChatMember] object on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup or channel (in the format  `@channelusername` )
 * @param[userId] Unique identifier of the target user
 */
fun BotContext.getChatMember(chatId: String, userId: Int): Future<ChatMember?> =
    awsl(genBotRequest("getChatMember", Pair("chat_id", chatId), Pair("user_id", userId)))

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field *can_set_sticker_set* optionally returned in [getChat][getChat] requests to check if the bot can use this method. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format  `@supergroupusername` )
 * @param[stickerSetName] Name of the sticker set to be set as the group sticker set
 */
fun BotContext.setChatStickerSet(chatId: String, stickerSetName: String): Future<Boolean?> =
    awsl(genBotRequest("setChatStickerSet", Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName)))

/**
 * Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field *can_set_sticker_set* optionally returned in [getChat][getChat] requests to check if the bot can use this method. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format  `@supergroupusername` )
 */
fun BotContext.deleteChatStickerSet(chatId: String): Future<Boolean?> =
    awsl(genBotRequest("deleteChatStickerSet", Pair("chat_id", chatId)))

/**
 * Use this method to send answers to callback queries sent from [inline keyboards](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, *True* is returned.
 * Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via [@Botfather](https://t.me/botfather) and accept the terms. Otherwise, you may use links like  `t.me/your_bot?start=XXXX`  that open your bot with a parameter.
 *
 * @param[callbackQueryId] Unique identifier for the query to be answered
 * @param[text] Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
 * @param[showAlert] If *true*, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to *false*.
 * @param[url] URL that will be opened by the user's client. If you have created a [Game][Game] and accepted the conditions via [@Botfather](https://t.me/botfather), specify the URL that opens your game – note that this will only work if the query comes from a [*callback_game*][InlineKeyboardButton] button. \
 * Otherwise, you may use links like  `t.me/your_bot?start=XXXX`  that open your bot with a parameter.
 * @param[cacheTime] The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
 */
fun BotContext.answerCallbackQuery(
    callbackQueryId: String,
    text: String? = null,
    showAlert: Boolean? = null,
    url: String? = null,
    cacheTime: Int? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "answerCallbackQuery",
        Pair("callback_query_id", callbackQueryId),
        Pair("text", text),
        Pair("show_alert", showAlert),
        Pair("url", url),
        Pair("cache_time", cacheTime)
    )
)

/**
 * Use this method to edit text and [game][null] messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[text] New text of the message
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in your bot's message.
 * @param[disableWebPagePreview] Disables link previews for links in this message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.editMessageText(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    text: String,
    parseMode: ParseMode? = null,
    disableWebPagePreview: Boolean? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "editMessageText",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("text", text),
        Pair("parse_mode", parseMode),
        Pair("disable_web_page_preview", disableWebPagePreview),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to edit captions of messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[caption] New caption of the message
 * @param[parseMode] Send [*Markdown*][null] or [*HTML*][null], if you want Telegram apps to show [bold, italic, fixed-width text or inline URLs][Formatting options] in the media caption.
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.editMessageCaption(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    caption: String? = null,
    parseMode: ParseMode? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "editMessageCaption",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("caption", caption),
        Pair("parse_mode", parseMode),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to edit animation, audio, document, photo, or video messages. If a message is a part of a message album, then it can be edited only to a photo or a video. Otherwise, message type can be changed arbitrarily. When inline message is edited, new file can't be uploaded. Use previously uploaded file via its file_id or specify a URL. On success, if the edited message was sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[media] A JSON-serialized object for a new media content of the message
 * @param[replyMarkup] A JSON-serialized object for a new [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.editMessageMedia(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    media: InputMedia,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "editMessageMedia",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("media", media),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to edit only the reply markup of messages. On success, if edited message is sent by the bot, the edited [Message][Message] is returned, otherwise *True* is returned.
 *
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the message to edit
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.editMessageReplyMarkup(
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "editMessageReplyMarkup",
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to stop a poll which was sent by the bot. On success, the stopped [Poll][Poll] with the final results is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Identifier of the original message with the poll
 * @param[replyMarkup] A JSON-serialized object for a new message [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating).
 */
fun BotContext.stopPoll(chatId: String, messageId: Int, replyMarkup: InlineKeyboardMarkup?): Future<Poll?> =
    awsl(
        genBotRequest(
            "stopPoll",
            Pair("chat_id", chatId),
            Pair("message_id", messageId),
            Pair("reply_markup", replyMarkup)
        )
    )

/**
 * Use this method to delete a message, including service messages, with the following limitations: \
 * - A message can only be deleted if it was sent less than 48 hours ago. \
 * - Bots can delete outgoing messages in private chats, groups, and supergroups. \
 * - Bots can delete incoming messages in private chats. \
 * - Bots granted *can_post_messages* permissions can delete outgoing messages in channels. \
 * - If the bot is an administrator of a group, it can delete any message there. \
 * - If the bot has *can_delete_messages* permission in a supergroup or a channel, it can delete any message there. \
 * Returns *True* on success.
 * The following methods and objects allow your bot to handle stickers and sticker sets.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[messageId] Identifier of the message to delete
 */
fun BotContext.deleteMessage(chatId: String, messageId: Int): Future<Boolean?> =
    awsl(genBotRequest("deleteMessage", Pair("chat_id", chatId), Pair("message_id", messageId)))

/**
 * Use this method to send static .WEBP or [animated](https://telegram.org/blog/animated-stickers) .TGS stickers. On success, the sent [Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target channel (in the format  `@channelusername` )
 * @param[sticker] Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .webp file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] Additional interface options. A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating), [custom reply keyboard](https://core.telegram.org/bots#keyboards), instructions to remove reply keyboard or to force a reply from the user.
 */
fun BotContext.sendSticker(
    chatId: String,
    sticker: String,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: ReplyMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendSticker",
        Pair("chat_id", chatId),
        Pair("sticker", sticker),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to get a sticker set. On success, a [StickerSet][StickerSet] object is returned.
 *
 * @param[name] Name of the sticker set
 */
fun BotContext.getStickerSet(name: String): Future<StickerSet?> =
    awsl(genBotRequest("getStickerSet", Pair("name", name)))

/**
 * Use this method to upload a .png file with a sticker for later use in *createNewStickerSet* and *addStickerToSet* methods (can be used multiple times). Returns the uploaded [File][File] on success.
 *
 * @param[userId] User identifier of sticker file owner
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. [More info on Sending Files »][Sending files]
 */
fun BotContext.uploadStickerFile(userId: Int, pngSticker: InputFile): Future<File?> =
    awsl(genBotRequest("uploadStickerFile", Pair("user_id", userId), Pair("png_sticker", pngSticker)))

/**
 * Use this method to create new sticker set owned by a user. The bot will be able to edit the created sticker set. Returns *True* on success.
 *
 * @param[userId] User identifier of created sticker set owner
 * @param[name] Short name of sticker set, to be used in  `t.me/addstickers/`  URLs (e.g., *animals*). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in *“_by_<bot username>”*. *<bot_username>* is case insensitive. 1-64 characters.
 * @param[title] Sticker set title, 1-64 characters
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a *file_id* as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[emojis] One or more emoji corresponding to the sticker
 * @param[containsMasks] Pass *True*, if a set of mask stickers should be created
 * @param[maskPosition] A JSON-serialized object for position where the mask should be placed on faces
 */
fun BotContext.createNewStickerSet(
    userId: Int,
    name: String,
    title: String,
    pngSticker: String,
    emojis: String,
    containsMasks: Boolean? = null,
    maskPosition: MaskPosition? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "createNewStickerSet",
        Pair("user_id", userId),
        Pair("name", name),
        Pair("title", title),
        Pair("png_sticker", pngSticker),
        Pair("emojis", emojis),
        Pair("contains_masks", containsMasks),
        Pair("mask_position", maskPosition)
    )
)

/**
 * Use this method to add a new sticker to a set created by the bot. Returns *True* on success.
 *
 * @param[userId] User identifier of sticker set owner
 * @param[name] Sticker set name
 * @param[pngSticker] **Png** image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a *file_id* as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. [More info on Sending Files »][Sending files]
 * @param[emojis] One or more emoji corresponding to the sticker
 * @param[maskPosition] A JSON-serialized object for position where the mask should be placed on faces
 */
fun BotContext.addStickerToSet(
    userId: Int,
    name: String,
    pngSticker: String,
    emojis: String,
    maskPosition: MaskPosition? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "addStickerToSet",
        Pair("user_id", userId),
        Pair("name", name),
        Pair("png_sticker", pngSticker),
        Pair("emojis", emojis),
        Pair("mask_position", maskPosition)
    )
)

/**
 * Use this method to move a sticker in a set created by the bot to a specific position . Returns *True* on success.
 *
 * @param[sticker] File identifier of the sticker
 * @param[position] New sticker position in the set, zero-based
 */
fun BotContext.setStickerPositionInSet(sticker: String, position: Int): Future<Boolean?> =
    awsl(genBotRequest("setStickerPositionInSet", Pair("sticker", sticker), Pair("position", position)))

/**
 * Use this method to delete a sticker from a set created by the bot. Returns *True* on success.
 * The following methods and objects allow your bot to work in [inline mode](https://core.telegram.org/bots/inline). \
 * Please see our [Introduction to Inline bots](https://core.telegram.org/bots/inline) for more details.
 * To enable this option, send the  `/setinline`  command to [@BotFather](https://t.me/botfather) and provide the placeholder text that the user will see in the input field after typing your bot’s name.
 *
 * @param[sticker] File identifier of the sticker
 */
fun BotContext.deleteStickerFromSet(sticker: String): Future<Boolean?> =
    awsl(genBotRequest("deleteStickerFromSet", Pair("sticker", sticker)))

/**
 * Use this method to send answers to an inline query. On success, *True* is returned. \
 * No more than **50** results per query are allowed.
 *
 * @param[inlineQueryId] Unique identifier for the answered query
 * @param[results] A JSON-serialized array of results for the inline query
 * @param[cacheTime] The maximum amount of time in seconds that the result of the inline query may be cached on the server. Defaults to 300.
 * @param[isPersonal] Pass *True*, if results may be cached on the server side only for the user that sent the query. By default, results may be returned to any user who sends the same query
 * @param[nextOffset] Pass the offset that a client should send in the next query with the same text to receive more results. Pass an empty string if there are no more results or if you don‘t support pagination. Offset length can’t exceed 64 bytes.
 * @param[switchPmText] If passed, clients will display a button with specified text that switches the user to a private chat with the bot and sends the bot a start message with the parameter *switch_pm_parameter*
 * @param[switchPmParameter] [Deep-linking](https://core.telegram.org/bots#deep-linking) parameter for the /start message sent to the bot when user presses the switch button. 1-64 characters, only  `A-Z` ,  `a-z` ,  `0-9` ,  `_`  and  `-`  are allowed. \
 * *Example:* An inline bot that sends YouTube videos can ask the user to connect the bot to their YouTube account to adapt search results accordingly. To do this, it displays a ‘Connect your YouTube account’ button above the results, or even before showing any. The user presses the button, switches to a private chat with the bot and, in doing so, passes a start parameter that instructs the bot to return an oauth link. Once done, the bot can offer a [*switch_inline*][InlineKeyboardMarkup] button so that the user can easily return to the chat where they wanted to use the bot's inline capabilities.
 */
fun BotContext.answerInlineQuery(
    inlineQueryId: String,
    results: Array<InlineQueryResult>,
    cacheTime: Int? = null,
    isPersonal: Boolean? = null,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "answerInlineQuery",
        Pair("inline_query_id", inlineQueryId),
        Pair("results", results),
        Pair("cache_time", cacheTime),
        Pair("is_personal", isPersonal),
        Pair("next_offset", nextOffset),
        Pair("switch_pm_text", switchPmText),
        Pair("switch_pm_parameter", switchPmParameter)
    )
)

/**
 * Use this method to send invoices. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target private chat
 * @param[title] Product name, 1-32 characters
 * @param[description] Product description, 1-255 characters
 * @param[payload] Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
 * @param[providerToken] Payments provider token, obtained via [Botfather](https://t.me/botfather)
 * @param[startParameter] Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
 * @param[currency] Three-letter ISO 4217 currency code, see [more on currencies](https://core.telegram.org/bots/payments#supported-currencies)
 * @param[prices] Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
 * @param[providerData] JSON-encoded data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
 * @param[photoUrl] URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
 * @param[photoSize] Photo size
 * @param[photoWidth] Photo width
 * @param[photoHeight] Photo height
 * @param[needName] Pass *True*, if you require the user's full name to complete the order
 * @param[needPhoneNumber] Pass *True*, if you require the user's phone number to complete the order
 * @param[needEmail] Pass *True*, if you require the user's email address to complete the order
 * @param[needShippingAddress] Pass *True*, if you require the user's shipping address to complete the order
 * @param[sendPhoneNumberToProvider] Pass *True*, if user's phone number should be sent to provider
 * @param[sendEmailToProvider] Pass *True*, if user's email address should be sent to provider
 * @param[isFlexible] Pass *True*, if the final price depends on the shipping method
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If empty, one 'Pay  `total price` ' button will be shown. If not empty, the first button must be a Pay button.
 */
fun BotContext.sendInvoice(
    chatId: String,
    title: String,
    description: String,
    payload: String,
    providerToken: String,
    startParameter: String,
    currency: String,
    prices: Array<LabeledPrice>,
    providerData: String? = null,
    photoUrl: String? = null,
    photoSize: Int? = null,
    photoWidth: Int? = null,
    photoHeight: Int? = null,
    needName: Boolean? = null,
    needPhoneNumber: Boolean? = null,
    needEmail: Boolean? = null,
    needShippingAddress: Boolean? = null,
    sendPhoneNumberToProvider: Boolean? = null,
    sendEmailToProvider: Boolean? = null,
    isFlexible: Boolean? = null,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendInvoice",
        Pair("chat_id", chatId),
        Pair("title", title),
        Pair("description", description),
        Pair("payload", payload),
        Pair("provider_token", providerToken),
        Pair("start_parameter", startParameter),
        Pair("currency", currency),
        Pair("prices", prices),
        Pair("provider_data", providerData),
        Pair("photo_url", photoUrl),
        Pair("photo_size", photoSize),
        Pair("photo_width", photoWidth),
        Pair("photo_height", photoHeight),
        Pair("need_name", needName),
        Pair("need_phone_number", needPhoneNumber),
        Pair("need_email", needEmail),
        Pair("need_shipping_address", needShippingAddress),
        Pair("send_phone_number_to_provider", sendPhoneNumberToProvider),
        Pair("send_email_to_provider", sendEmailToProvider),
        Pair("is_flexible", isFlexible),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * If you sent an invoice requesting a shipping address and the parameter *is_flexible* was specified, the Bot API will send an [Update][Update] with a *shipping_query* field to the bot. Use this method to reply to shipping queries. On success, True is returned.
 *
 * @param[shippingQueryId] Unique identifier for the query to be answered
 * @param[ok] Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
 * @param[shippingOptions] Required if *ok* is True. A JSON-serialized array of available shipping options.
 * @param[errorMessage] Required if *ok* is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
 */
fun BotContext.answerShippingQuery(
    shippingQueryId: String,
    ok: Boolean,
    shippingOptions: Array<ShippingOption>? = null,
    errorMessage: String? = null
): Future<Boolean?> = awsl(
    genBotRequest(
        "answerShippingQuery",
        Pair("shipping_query_id", shippingQueryId),
        Pair("ok", ok),
        Pair("shipping_options", shippingOptions),
        Pair("error_message", errorMessage)
    )
)

/**
 * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an [Update][Update] with the field *pre_checkout_query*. Use this method to respond to such pre-checkout queries. On success, True is returned. **Note:** The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
 *
 * @param[preCheckoutQueryId] Unique identifier for the query to be answered
 * @param[ok] Specify *True* if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use *False* if there are any problems.
 * @param[errorMessage] Required if *ok* is *False*. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
 */
fun BotContext.answerPreCheckoutQuery(
    preCheckoutQueryId: String,
    ok: Boolean,
    errorMessage: String?
): Future<Boolean?> =
    awsl(
        genBotRequest(
            "answerPreCheckoutQuery",
            Pair("pre_checkout_query_id", preCheckoutQueryId),
            Pair("ok", ok),
            Pair("error_message", errorMessage)
        )
    )

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns *True* on success.
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
 *
 * @param[userId] User identifier
 * @param[errors] A JSON-serialized array describing the errors
 */
fun BotContext.setPassportDataErrors(userId: Int, errors: Array<PassportElementError>): Future<Boolean?> =
    awsl(genBotRequest("setPassportDataErrors", Pair("user_id", userId), Pair("errors", errors)))

/**
 * Use this method to send a game. On success, the sent [Message][Message] is returned.
 *
 * @param[chatId] Unique identifier for the target chat
 * @param[gameShortName] Short name of the game, serves as the unique identifier for the game. Set up your games via [Botfather](https://t.me/botfather).
 * @param[disableNotification] Sends the message [silently](https://telegram.org/blog/channels-2-0#silent-messages). Users will receive a notification with no sound.
 * @param[replyToMessageId] If the message is a reply, ID of the original message
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If empty, one ‘Play game_title’ button will be shown. If not empty, the first button must launch the game.
 */
fun BotContext.sendGame(
    chatId: String,
    gameShortName: String,
    disableNotification: Boolean? = null,
    replyToMessageId: Int? = null,
    replyMarkup: InlineKeyboardMarkup? = null
): Future<Message?> = awsl(
    genBotRequest(
        "sendGame",
        Pair("chat_id", chatId),
        Pair("game_short_name", gameShortName),
        Pair("disable_notification", disableNotification),
        Pair("reply_to_message_id", replyToMessageId),
        Pair("reply_markup", replyMarkup)
    )
)

/**
 * Use this method to set the score of the specified user in a game. On success, if the message was sent by the bot, returns the edited [Message][Message], otherwise returns *True*. Returns an error, if the new score is not greater than the user's current score in the chat and *force* is *False*.
 *
 * @param[userId] User identifier
 * @param[score] New score, must be non-negative
 * @param[force] Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
 * @param[disableEditMessage] Pass True, if the game message should not be automatically edited to include the current scoreboard
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the sent message
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 */
fun BotContext.setGameScore(
    userId: Int,
    score: Int,
    force: Boolean? = null,
    disableEditMessage: Boolean? = null,
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String? = null
): Future<Either<Boolean, Message>?> = awslByEither(
    genBotRequest(
        "setGameScore",
        Pair("user_id", userId),
        Pair("score", score),
        Pair("force", force),
        Pair("disable_edit_message", disableEditMessage),
        Pair("chat_id", chatId),
        Pair("message_id", messageId),
        Pair("inline_message_id", inlineMessageId)
    )
)

/**
 * Use this method to get data for high score tables. Will return the score of the specified user and several of his neighbors in a game. On success, returns an *Array* of [GameHighScore][GameHighScore] objects.
 * This method will currently return scores for the target user, plus two of his closest neighbors on each side. Will also return the top three users if the user and his neighbors are not among them. Please note that this behavior is subject to change.
 *
 * @param[userId] Target user id
 * @param[chatId] Required if *inline_message_id* is not specified. Unique identifier for the target chat
 * @param[messageId] Required if *inline_message_id* is not specified. Identifier of the sent message
 * @param[inlineMessageId] Required if *chat_id* and *message_id* are not specified. Identifier of the inline message
 */
fun BotContext.getGameHighScores(
    userId: Int,
    chatId: String? = null,
    messageId: Int? = null,
    inlineMessageId: String?
): Future<Array<GameHighScore>?> =
    awslByArray(
        genBotRequest(
            "getGameHighScores",
            Pair("user_id", userId),
            Pair("chat_id", chatId),
            Pair("message_id", messageId),
            Pair("inline_message_id", inlineMessageId)
        )
    )
