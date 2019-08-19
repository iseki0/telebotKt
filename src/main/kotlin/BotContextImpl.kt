import api.ResultType
import io.vertx.core.Future

class BotContextImpl(private val botServer: BotServer) : ApiContext {
    override var timeout: Long? = null

    override fun <T : ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T?> = botServer.doSendRequest(
        command, args, resultType, timeout ?: defaultHttpTimeout(
            command,
            args
        )
    )
}