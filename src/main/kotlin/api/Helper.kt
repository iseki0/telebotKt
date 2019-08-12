package api

import io.vertx.core.Future

inline fun <reified T> ApiContext.sendRequest(command: String, args: List<Pair<String, Any?>>): Future<T?> =
    doSendRequest(command, args, T::class.java)

inline fun <reified T> ApiContext.sendRequestCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (T?) -> Unit
): ApiContext {

    TODO()
}

suspend inline fun <reified T> ApiContext.sendRequestAwait(command: String, args: List<Pair<String, Any?>>): T? =
    TODO()

inline fun <reified O, S> ApiContext.sendRequestEither(
    command: String,
    args: List<Pair<String, Any?>>
): Future<Either<O, S>?> =
    TODO()

inline fun <reified O, S> ApiContext.sendRequestEitherCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (Either<O, S>?) -> Unit
): ApiContext =
    TODO()

suspend inline fun <reified O, S> ApiContext.sendRequestEitherAwait(
    command: String,
    args: List<Pair<String, Any?>>
): Either<O, S> {
    TODO()
}