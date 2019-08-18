package api

import io.vertx.core.AsyncResult
import io.vertx.core.Future

inline fun <reified T : ResultType?> ApiContext.sendRequest(
    command: String,
    args: List<Pair<String, Any?>>
): Future<T?> =
    doSendRequest(command, args, T::class.java)

inline fun <reified T> ApiContext.sendRequestCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (AsyncResult<T?>) -> Unit,
    rawType: Class<*>? = null
): ApiContext {

    TODO()
}

suspend inline fun <reified T> ApiContext.sendRequestAwait(command: String, args: List<Pair<String, Any?>>): T? =
    TODO()
