import api.ResultType
import api.type.*
import io.vertx.core.Future
import io.vertx.core.Vertx

interface BotServer {


    fun <T : ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>,
        timeout: Long
    ): Future<T?>

    fun dispatchUpdate(update: Update)

    fun registerNewMessageHandler(lambda: (msg: Message) -> Boolean)
    fun registerEditedMessageHandler(lambda: (msg: Message) -> Boolean)
    fun registerChannelPost(lambda: (msg: Message) -> Boolean)
    fun registerEditedChannelPost(lambda: (msg: Message) -> Boolean)
    fun registerInlineQuery(lambda: (msg: InlineQuery) -> Boolean)
    fun registerChosenInlineResult(lambda: (msg: ChosenInlineResult) -> Boolean)
    fun registerCallbackQuery(lambda: (msg: CallbackQuery) -> Boolean)
    fun registerShippingQuery(lambda: (msg: ShippingQuery) -> Boolean)
    fun registerPreCheckoutQuery(lambda: (msg: PreCheckoutQuery) -> Boolean)
    fun registerPoll(lambda: (msg: Poll) -> Boolean)

    fun getApiContext(): ApiContext
    val vertx: Vertx
}