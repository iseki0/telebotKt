@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Update
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an [Update][Update] with the field *pre_checkout_query*. Use this method to respond to such pre-checkout queries. On success, True is returned. **Note:** The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
 *
 * @param[preCheckoutQueryId] Unique identifier for the query to be answered
 * @param[ok] Specify *True* if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use *False* if there are any problems.
 * @param[errorMessage] Required if *ok* is *False*. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
 */
fun ApiContext.answerPreCheckoutQuery(
    preCheckoutQueryId: String,
    ok: Boolean,
    errorMessage: String? = null
): Future<AnswerPreCheckoutQueryResult?> = sendRequest<AnswerPreCheckoutQueryResult?>(
    "answerPreCheckoutQuery",
    listOf(Pair("pre_checkout_query_id", preCheckoutQueryId), Pair("ok", ok), Pair("error_message", errorMessage))
)

fun ApiContext.answerPreCheckoutQuery(
    preCheckoutQueryId: String,
    ok: Boolean,
    errorMessage: String? = null,
    callback: (result: AsyncResult<AnswerPreCheckoutQueryResult?>) -> Unit
): ApiContext = sendRequestCallback<AnswerPreCheckoutQueryResult?>(
    "answerPreCheckoutQuery",
    listOf(Pair("pre_checkout_query_id", preCheckoutQueryId), Pair("ok", ok), Pair("error_message", errorMessage)),
    callback
)

suspend fun ApiContext.answerPreCheckoutQueryAwait(
    preCheckoutQueryId: String,
    ok: Boolean,
    errorMessage: String? = null
): AnswerPreCheckoutQueryResult? = sendRequestAwait<AnswerPreCheckoutQueryResult?>(
    "answerPreCheckoutQuery",
    listOf(Pair("pre_checkout_query_id", preCheckoutQueryId), Pair("ok", ok), Pair("error_message", errorMessage))
)