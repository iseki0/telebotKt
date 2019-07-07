@file:Suppress("unused")

package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This [object][null] represents an incoming update. \
 * At most **one** of the optional parameters can be present in any given update.
 *
 * @param[updateId] The update‘s unique identifier. types.Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using [Webhooks][setWebhook], since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @param[message] *Optional*. New incoming message of any kind — text, photo, sticker, etc.
 * @param[editedMessage] *Optional*. New version of a message that is known to the bot and was edited
 * @param[channelPost] *Optional*. New incoming channel post of any kind — text, photo, sticker, etc.
 * @param[editedChannelPost] *Optional*. New version of a channel post that is known to the bot and was edited
 * @param[inlineQuery] *Optional*. New incoming [inline][null] query
 * @param[chosenInlineResult] *Optional*. The result of an [inline][null] query that was chosen by a user and sent to their chat partner. Please see our documentation on the [feedback collecting](https://core.telegram.org/bots/inline#collecting-feedback) for details on how to enable these updates for your bot.
 * @param[callbackQuery] *Optional*. New incoming callback query
 * @param[shippingQuery] *Optional*. New incoming shipping query. Only for invoices with flexible price
 * @param[preCheckoutQuery] *Optional*. New incoming pre-checkout query. Contains full information about checkout
 * @param[poll] *Optional*. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Update @JsonCreator constructor(
    @JsonProperty("update_id")
    val updateId: Int,
    @JsonProperty("message")
    val message: Message? = null,
    @JsonProperty("edited_message")
    val editedMessage: Message? = null,
    @JsonProperty("channel_post")
    val channelPost: Message? = null,
    @JsonProperty("edited_channel_post")
    val editedChannelPost: Message? = null,
    @JsonProperty("inline_query")
    val inlineQuery: InlineQuery? = null,
    @JsonProperty("chosen_inline_result")
    val chosenInlineResult: ChosenInlineResult? = null,
    @JsonProperty("callback_query")
    val callbackQuery: CallbackQuery? = null,
    @JsonProperty("shipping_query")
    val shippingQuery: ShippingQuery? = null,
    @JsonProperty("pre_checkout_query")
    val preCheckoutQuery: PreCheckoutQuery? = null,
    @JsonProperty("poll")
    val poll: Poll? = null
)