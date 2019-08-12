@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.ApiContext
import api.sendRequest
import api.sendRequestAwait
import api.sendRequestCallback
import api.type.ShippingOption
import api.type.Update
import io.vertx.core.Future

/**
 * If you sent an invoice requesting a shipping address and the parameter *is_flexible* was specified, the Bot API will send an [Update][Update] with a *shipping_query* field to the bot. Use this method to reply to shipping queries. On success, True is returned.
 *
 * @param[shippingQueryId] Unique identifier for the query to be answered
 * @param[ok] Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
 * @param[shippingOptions] Required if *ok* is True. A JSON-serialized array of available shipping options.
 * @param[errorMessage] Required if *ok* is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
 */
fun ApiContext.answerShippingQuery(
    shippingQueryId: String,
    ok: Boolean,
    shippingOptions: List<ShippingOption>? = null,
    errorMessage: String? = null
): Future<Boolean?> = sendRequest<Boolean?>(
    "answerShippingQuery",
    listOf(
        Pair("shipping_query_id", shippingQueryId),
        Pair("ok", ok),
        Pair("shipping_options", shippingOptions),
        Pair("error_message", errorMessage)
    )
)

fun ApiContext.answerShippingQuery(
    shippingQueryId: String,
    ok: Boolean,
    shippingOptions: List<ShippingOption>? = null,
    errorMessage: String? = null,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "answerShippingQuery",
    listOf(
        Pair("shipping_query_id", shippingQueryId),
        Pair("ok", ok),
        Pair("shipping_options", shippingOptions),
        Pair("error_message", errorMessage)
    ),
    callback
)

suspend fun ApiContext.answerShippingQueryAwait(
    shippingQueryId: String,
    ok: Boolean,
    shippingOptions: List<ShippingOption>? = null,
    errorMessage: String? = null
): Boolean? = sendRequestAwait<Boolean?>(
    "answerShippingQuery",
    listOf(
        Pair("shipping_query_id", shippingQueryId),
        Pair("ok", ok),
        Pair("shipping_options", shippingOptions),
        Pair("error_message", errorMessage)
    )
)