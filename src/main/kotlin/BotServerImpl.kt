import api.InputFile
import api.ResultType
import api.UpdateType
import api.type.*
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.buffer.Buffer
import io.vertx.core.json.Json
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.ext.web.multipart.MultipartForm

const val HTTP_REQUEST_TIMEOUT = 5000L


class BotServerImpl(
    override val vertx: Vertx,
    val botKey: String,
    val webClientOptions: WebClientOptions = WebClientOptions()
) : BotServer {
    override fun getApiContext(): ApiContext = BotContextImpl(this)
    var exceptionHandler: (e: Exception) -> Unit = {}
    val baseContext: ApiContext = BotContextImpl(this)
    private val webClient: WebClient =
        WebClient.create(vertx, webClientOptions)

    private val baseUrl: String = """https://api.telegram.org/bot$botKey"""

    val handlerMap = HashMap<UpdateType, ArrayList<(Any) -> Boolean>>()
    private fun <T> putHandlerToMap(type: UpdateType, lambda: (msg: T) -> Boolean) {
        handlerMap.getOrPut(type, { ArrayList() }).add(lambda as (Any) -> Boolean)
    }

    override fun registerEditedMessageHandler(lambda: (msg: Message) -> Boolean) =
        putHandlerToMap(UpdateType.EDITED_MESSAGE, lambda)

    override fun registerChannelPost(lambda: (msg: Message) -> Boolean) =
        putHandlerToMap(UpdateType.CHANNEL_POST, lambda)

    override fun registerEditedChannelPost(lambda: (msg: Message) -> Boolean) =
        putHandlerToMap(UpdateType.EDITED_CHANNEL_POST, lambda)

    override fun registerInlineQuery(lambda: (msg: InlineQuery) -> Boolean) =
        putHandlerToMap(UpdateType.INLINE_QUERY, lambda)

    override fun registerChosenInlineResult(lambda: (msg: ChosenInlineResult) -> Boolean) =
        putHandlerToMap(UpdateType.CHOSEN_INLINE_QUERY, lambda)

    override fun registerCallbackQuery(lambda: (msg: CallbackQuery) -> Boolean) =
        putHandlerToMap(UpdateType.CALLBACK_QUERY, lambda)

    override fun registerShippingQuery(lambda: (msg: ShippingQuery) -> Boolean) =
        putHandlerToMap(UpdateType.SHIPPING_QUERY, lambda)

    override fun registerPreCheckoutQuery(lambda: (msg: PreCheckoutQuery) -> Boolean) =
        putHandlerToMap(UpdateType.PRE_CHECKOUT_QUERY, lambda)

    override fun registerPoll(lambda: (msg: Poll) -> Boolean) =
        putHandlerToMap(UpdateType.POLL, lambda)

    override fun registerNewMessageHandler(lambda: (msg: Message) -> Boolean) =
        putHandlerToMap(UpdateType.MESSAGE, lambda)

    override fun dispatchUpdate(update: Update) {
        when {
            update.message != null ->
                doDispatcher(UpdateType.MESSAGE, update.message)
            update.editedMessage != null ->
                doDispatcher(UpdateType.EDITED_MESSAGE, update.editedMessage)
            update.channelPost != null ->
                doDispatcher(UpdateType.CHANNEL_POST, update.channelPost)
            update.editedChannelPost != null ->
                doDispatcher(UpdateType.EDITED_CHANNEL_POST, update.editedChannelPost)
            update.inlineQuery != null ->
                doDispatcher(UpdateType.INLINE_QUERY, update.inlineQuery)
            update.chosenInlineResult != null ->
                doDispatcher(UpdateType.CHOSEN_INLINE_QUERY, update.chosenInlineResult)
            update.callbackQuery != null ->
                doDispatcher(UpdateType.CALLBACK_QUERY, update.callbackQuery)
            update.shippingQuery != null ->
                doDispatcher(UpdateType.SHIPPING_QUERY, update.shippingQuery)
            update.preCheckoutQuery != null ->
                doDispatcher(UpdateType.PRE_CHECKOUT_QUERY, update.preCheckoutQuery)
            update.poll != null ->
                doDispatcher(UpdateType.POLL, update.poll)
            else -> throw RuntimeException("UnknownUpdateType: $update")
        }
    }

    fun <T> doDispatcher(type: UpdateType, data: T) {
        handlerMap[type]?.forEach {
            if (it(data as Any)) return
        }
    }


    override fun <T : ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>,
        timeout: Long
    ): Future<T?> =
        Future.future { promise ->
            val url = "$baseUrl/$command"
            val request = webClient.postAbs(url)
            request.timeout(timeout)

            val targs = args.filter { it.second != null }
            if (targs.isEmpty()) {
                request.send {
                    if (it.succeeded()) {
                        handleResult(promise, it.result(), resultType)
                    } else {
                        promise.fail(it.cause())
                    }
                }
            } else {
                val form = MultipartForm.create()
                putArgsToForm(targs, form)
                request.sendMultipartForm(form) {
                    if (it.succeeded()) {
                        handleResult(promise, it.result(), resultType)
                    } else {
                        promise.fail(it.cause())
                    }
                }
            }
        }
}


fun putArgsToForm(args: List<Pair<String, Any?>>, form: MultipartForm) =
    args.forEach { (key, value) ->
        when {
            value is InputFile -> {
                if (value.file != null) {
                    form.binaryFileUpload(key, value.file.name, value.file.absolutePath, "")
                } else {
                    form.attribute(key, value.fileId)
                }
            }
            isSimpleType(value) -> form.attribute(key, value.toString())
            else -> form.attribute(key, Json.mapper.writeValueAsString(value))
        }
    }


private fun <T : ResultType?> handleResult(
    promise: Promise<T>,
    httpResult: HttpResponse<Buffer>,
    resultType: Class<T>
) {
    try {
        val a = httpResult.bodyAsString()
        val r = Json.mapper.readValue<T>(a ?: throw RuntimeException("body is null."), resultType)
        if (r?.ok ?: throw RuntimeException("\"ok\" field isn't exists.")) {
            promise.complete(r)
        } else {
            throw TelegramRequestFail(errorCode = r.errorCode ?: -1, description = r.description ?: "")
        }
    } catch (e: Exception) {
        promise.fail(e)
    }
}


fun defaultHttpTimeout(command: String, args: List<Pair<String, Any?>>): Long =
    when (command) {
        // command `getUpdates` request timeout must large than it's value.
        "getUpdates" -> (args.toMap()["timeout"]?.toString()?.toLong() ?: 5) * 1000 + 500
        else -> HTTP_REQUEST_TIMEOUT
    }

fun isSimpleType(o: Any?): Boolean =
    when (o) {
        null -> true
        String -> true
        Int -> true
        Long -> true
        Boolean -> true
        Double -> true
        else -> false
    }
