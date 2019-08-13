package api

import io.vertx.core.AsyncResult
import io.vertx.core.Future

inline fun <reified T> ApiContext.sendRequest(
    command: String,
    args: List<Pair<String, Any?>>,
    resultType: TypeReference<*>
): Future<T?> =
    doSendRequest(command, args, resultType)

inline fun <reified T> ApiContext.sendRequestCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (AsyncResult<T?>) -> Unit,
    resultType: TypeReference<*>
): ApiContext {
    doSendRequest<T>(command, args, resultType).setHandler { callback(it) }
    return this
}

suspend inline fun <reified T> ApiContext.sendRequestAwait(
    command: String,
    args: List<Pair<String, Any?>>,
    resultType: TypeReference<*>
): T? =
    TODO()

