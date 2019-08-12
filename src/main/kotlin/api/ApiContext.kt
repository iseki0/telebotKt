package api

import io.vertx.core.Future

interface ApiContext {
    fun <T> doSendRequest(command: String, args: List<Pair<String, Any?>>, resultType: Class<T>): Future<T?>
}