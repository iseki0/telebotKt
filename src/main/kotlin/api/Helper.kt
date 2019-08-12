package api

inline fun <reified T> ApiContext.sendRequest(command: String, args: List<Pair<String, Any?>>): Future<T?> =
    TODO()

inline fun <reified T> ApiContext.sendRequestCallback(
    command: String,
    args: List<Pair<String, Any?>>,
    crossinline callback: (T?) -> Unit
): ApiContext =
    TODO()

suspend inline fun <reified T> ApiContext.sendRequestAwait(command: String, args: List<Pair<String, Any?>>): T? =
    TODO()

fun a(apiContext: ApiContext) {

}