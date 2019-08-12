@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.func.setWebhook
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This [object](https://core.telegram.org#available-types) represents an incoming update.
 * At most **one** of the optional parameters can be present in any given update.
 *
 * @param[updateId] The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using [Webhooks][setWebhook], since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
 * @param[message] *Optional*. New incoming message of any kind — text, photo, sticker, etc.
 * @param[editedMessage] *Optional*. New version of a message that is known to the bot and was edited
 * @param[channelPost] *Optional*. New incoming channel post of any kind — text, photo, sticker, etc.
 * @param[editedChannelPost] *Optional*. New version of a channel post that is known to the bot and was edited
 * @param[inlineQuery] *Optional*. New incoming [inline](https://core.telegram.org#inline-mode) query
 * @param[chosenInlineResult] *Optional*. The result of an [inline](https://core.telegram.org#inline-mode) query that was chosen by a user and sent to their chat partner. Please see our documentation on the [feedback collecting](https://core.telegram.org/bots/inline#collecting-feedback) for details on how to enable these updates for your bot.
 * @param[callbackQuery] *Optional*. New incoming callback query
 * @param[shippingQuery] *Optional*. New incoming shipping query. Only for invoices with flexible price
 * @param[preCheckoutQuery] *Optional*. New incoming pre-checkout query. Contains full information about checkout
 * @param[poll] *Optional*. New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Update @JsonCreator constructor(
    @get:JsonProperty("update_id")
    @JsonProperty("update_id")
    val updateId: Int,
    @get:JsonProperty("message")
    @JsonProperty("message")
    val message: Message? = null,
    @get:JsonProperty("edited_message")
    @JsonProperty("edited_message")
    val editedMessage: Message? = null,
    @get:JsonProperty("channel_post")
    @JsonProperty("channel_post")
    val channelPost: Message? = null,
    @get:JsonProperty("edited_channel_post")
    @JsonProperty("edited_channel_post")
    val editedChannelPost: Message? = null,
    @get:JsonProperty("inline_query")
    @JsonProperty("inline_query")
    val inlineQuery: InlineQuery? = null,
    @get:JsonProperty("chosen_inline_result")
    @JsonProperty("chosen_inline_result")
    val chosenInlineResult: ChosenInlineResult? = null,
    @get:JsonProperty("callback_query")
    @JsonProperty("callback_query")
    val callbackQuery: CallbackQuery? = null,
    @get:JsonProperty("shipping_query")
    @JsonProperty("shipping_query")
    val shippingQuery: ShippingQuery? = null,
    @get:JsonProperty("pre_checkout_query")
    @JsonProperty("pre_checkout_query")
    val preCheckoutQuery: PreCheckoutQuery? = null,
    @get:JsonProperty("poll")
    @JsonProperty("poll")
    val poll: Poll? = null
)