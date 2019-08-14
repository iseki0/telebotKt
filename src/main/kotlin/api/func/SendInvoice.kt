@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.InlineKeyboardMarkup
import api.type.LabeledPrice
import api.type.Message
import io.vertx.core.AsyncResult
import io.vertx.core.Future

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
 * @param[replyMarkup] A JSON-serialized object for an [inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating). If empty, one 'Pay `total price`' button will be shown. If not empty, the first button must be a Pay button.
 */
fun ApiContext.sendInvoice(
    chatId: Int,
    title: String,
    description: String,
    payload: String,
    providerToken: String,
    startParameter: String,
    currency: String,
    prices: List<LabeledPrice>,
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
): Future<SendInvoiceResult?> = sendRequest<SendInvoiceResult?>(
    "sendInvoice",
    listOf(
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

fun ApiContext.sendInvoice(
    chatId: Int,
    title: String,
    description: String,
    payload: String,
    providerToken: String,
    startParameter: String,
    currency: String,
    prices: List<LabeledPrice>,
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
    replyMarkup: InlineKeyboardMarkup? = null,
    callback: (result: AsyncResult<SendInvoiceResult?>) -> Unit
): ApiContext = sendRequestCallback<SendInvoiceResult?>(
    "sendInvoice",
    listOf(
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
    ),
    callback
)

suspend fun ApiContext.sendInvoiceAwait(
    chatId: Int,
    title: String,
    description: String,
    payload: String,
    providerToken: String,
    startParameter: String,
    currency: String,
    prices: List<LabeledPrice>,
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
): SendInvoiceResult? = sendRequestAwait<SendInvoiceResult?>(
    "sendInvoice",
    listOf(
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