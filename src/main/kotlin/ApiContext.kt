import api.ResultType
import io.vertx.core.Future

interface ApiContext {
    fun <T : ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T?>

    var timeout: Long?
}