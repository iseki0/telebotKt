@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import api.type.Update

/**
 * Use this method to receive incoming updates using long polling ([wiki](http://en.wikipedia.org/wiki/Push_technology#Long_polling)). An Array of [Update][Update] objects is returned.
 *
 * @param[offset] Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as [getUpdates][getUpdates] is called with an *offset* higher than its *update_id*. The negative offset can be specified to retrieve updates starting from *-offset* update from the end of the updates queue. All previous updates will forgotten.
 * @param[limit] Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100.
 * @param[timeout] Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * @param[allowedUpdates] List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See [Update][Update] for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 */
fun ApiContext.getUpdates(
    offset: Int? = null,
    limit: Int? = null,
    timeout: Int? = null,
    allowedUpdates: List<AllowedUpdate>? = null
): Future<List<Update>?> = sendRequest<List<Update>?>(
    "getUpdates",
    listOf(
        Pair("offset", offset),
        Pair("limit", limit),
        Pair("timeout", timeout),
        Pair("allowed_updates", allowedUpdates)
    )
)

fun ApiContext.getUpdates(
    offset: Int? = null,
    limit: Int? = null,
    timeout: Int? = null,
    allowedUpdates: List<String>? = null,
    callback: (result: List<Update>?) -> Unit
): ApiContext = sendRequestCallback<List<Update>?>(
    "getUpdates",
    listOf(
        Pair("offset", offset),
        Pair("limit", limit),
        Pair("timeout", timeout),
        Pair("allowed_updates", allowedUpdates)
    ),
    callback
)

suspend fun ApiContext.getUpdatesAwait(
    offset: Int? = null,
    limit: Int? = null,
    timeout: Int? = null,
    allowedUpdates: List<String>? = null
): List<Update>? = sendRequestAwait<List<Update>?>(
    "getUpdates",
    listOf(
        Pair("offset", offset),
        Pair("limit", limit),
        Pair("timeout", timeout),
        Pair("allowed_updates", allowedUpdates)
    )
)