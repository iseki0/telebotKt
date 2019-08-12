@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.Future

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns *True* on success.
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
 *
 * @param[userId] User identifier
 * @param[errors] A JSON-serialized array describing the errors
 */
fun ApiContext.setPassportDataErrors(
    userId: Int,
    errors: List<PassportElementError>
): Future<Boolean?> =
    sendRequest<Boolean?>("setPassportDataErrors", listOf(Pair("user_id", userId), Pair("errors", errors)))

fun ApiContext.setPassportDataErrors(
    userId: Int,
    errors: List<PassportElementError>,
    callback: (result: Boolean?) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setPassportDataErrors",
    listOf(Pair("user_id", userId), Pair("errors", errors)),
    callback
)

suspend fun ApiContext.setPassportDataErrorsAwait(
    userId: Int,
    errors: List<PassportElementError>
): Boolean? =
    sendRequestAwait<Boolean?>("setPassportDataErrors", listOf(Pair("user_id", userId), Pair("errors", errors)))