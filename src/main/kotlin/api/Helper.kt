package api

import ApiContext
import io.vertx.core.AsyncResult
import io.vertx.core.Future

inline fun <reified T : ResultType> ApiContext.sendRequest(
    command: String,
    args: List<Pair<String, Any?>>
): Future<T> =
    doSendRequest(command, args, T::class.java)

inline fun <reified T : ResultType> ApiContext.sendRequestCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (AsyncResult<T>) -> Unit
): ApiContext {
    doSendRequest(command, args, T::class.java).setHandler {
        callback(it)
    }
    return this
}

suspend inline fun <reified T : ResultType> ApiContext.sendRequestAwait(
    command: String,
    args: List<Pair<String, Any?>>
): T =
    TODO()

