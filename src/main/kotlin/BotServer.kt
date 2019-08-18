import api.ApiContext
import api.InputFile
import api.ResultType
import io.vertx.core.Future
import io.vertx.core.Promise
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.json.Json
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.multipart.MultipartForm

const val HTTP_REQUEST_TIMEOUT = 5000L

class BotServerImpl {
    var httpClientOptions = HttpClientOptions()
    var exceptionHandler: (e: Exception) -> Unit = {}

}

class BotContextImpl : ApiContext {
    override var timeout: Long? = null

    private val webClient: WebClient = TODO()

    private val baseUrl: String = TODO()

    override fun <T: ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T?> =
        Future.future { promise ->
            val url = baseUrl + command
            val request = webClient.postAbs(url)
            val form = MultipartForm.create()

            // different type, different behavior
            args.filter { it.second != null }.forEach { (key, value) ->
                when {
                    value is InputFile -> TODO()
                    isSimpleType(value) -> form.attribute(key, value.toString())
                    else -> form.attribute(key, Json.mapper.writeValueAsString(value))
                }
            }

            // set context timeout, otherwise set default timeout.
            // different API, different timeout.
            if (timeout != null) {
                request.timeout(timeout!!)
            }else{
                request.timeout(defaultHttpTimeout(command, args))
            }
            // send request here.
            request.sendMultipartForm(form) {
                if (it.succeeded()){
                    handleResult(promise,it.result(),resultType)
                }else{
                    promise.fail(it.cause())
                }
            }
        }
}

private fun <T:ResultType?> handleResult(
    promise: Promise<T>,
    httpResult: HttpResponse<Buffer>,
    resultType: Class<T>
){
    try {
        val a=httpResult.bodyAsString()
        val r=Json.mapper.readValue<T>(a?: throw RuntimeException("body is null."),resultType)
        if (r?.ok?:throw RuntimeException("\"ok\" field isn't exists.")){
            promise.complete(r)
        }else{
            throw TelegramRequestFail(errorCode = r.errorCode ?:-1, description = r.description?:"")
        }
    }catch (e:Exception){
        promise.fail(e)
    }
}


fun defaultHttpTimeout(command: String, args: List<Pair<String, Any?>>): Long =
    when (command) {
        // command `getUpdates` request timeout must large than it's value.
        "getUpdates" -> args.toMap()["timeout"].toString().toLong()+500
        else -> HTTP_REQUEST_TIMEOUT
    }

fun isSimpleType(o: Any?): Boolean =
    when (o) {
        null -> true
        String -> true
        Int -> true
        Boolean -> true
        Double -> true
        else -> false
    }

class TelegramRequestFail(val errorCode:Int, val description:String):RuntimeException()