@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to send answers to callback queries sent from [inline keyboards](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, *True* is returned.
 * >  Alternatively, the user can be redirected to the specified Game URL. For this option to work, you must first create a game for your bot via [@Botfather](https://t.me/botfather) and accept the terms. Otherwise, you may use links like `t.me/your_bot?start=XXXX` that open your bot with a parameter.
 *
 * @param[callbackQueryId] Unique identifier for the query to be answered
 * @param[text] Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
 * @param[showAlert] If *true*, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to *false*.
 * @param[url] URL that will be opened by the user's client. If you have created a [Game][Game] and accepted the conditions via [@Botfather](https://t.me/botfather), specify the URL that opens your game – note that this will only work if the query comes from a [*callback_game*][InlineKeyboardButton] button.Otherwise, you may use links like `t.me/your_bot?start=XXXX` that open your bot with a parameter.
 * @param[cacheTime] The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
 */
fun ApiContext.answerCallbackQuery(
    callbackQueryId: String,
    text: String? = null,
    showAlert: Boolean? = null,
    url: String? = null,
    cacheTime: Int? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "answerCallbackQuery",
    listOf(
        Pair("callback_query_id", callbackQueryId),
        Pair("text", text),
        Pair("show_alert", showAlert),
        Pair("url", url),
        Pair("cache_time", cacheTime)
    ),
    object : TypeReference<Boolean> {})

fun ApiContext.answerCallbackQuery(
    callbackQueryId: String,
    text: String? = null,
    showAlert: Boolean? = null,
    url: String? = null,
    cacheTime: Int? = null,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "answerCallbackQuery",
    listOf(
        Pair("callback_query_id", callbackQueryId),
        Pair("text", text),
        Pair("show_alert", showAlert),
        Pair("url", url),
        Pair("cache_time", cacheTime)
    ),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.answerCallbackQueryAwait(
    callbackQueryId: String,
    text: String? = null,
    showAlert: Boolean? = null,
    url: String? = null,
    cacheTime: Int? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "answerCallbackQuery",
    listOf(
        Pair("callback_query_id", callbackQueryId),
        Pair("text", text),
        Pair("show_alert", showAlert),
        Pair("url", url),
        Pair("cache_time", cacheTime)
    ),
    object : TypeReference<Boolean> {})