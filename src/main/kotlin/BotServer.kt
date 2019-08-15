import api.ApiContext
import api.InputFile
import api.ResultType
import io.vertx.core.Future
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.json.Json
import io.vertx.ext.web.client.WebClient
import io.vertx.ext.web.multipart.MultipartForm

const val HTTP_REQUEST_TIMEOUT = 5000

class BotServerImpl {
    var httpClientOptions = HttpClientOptions()
    var exceptionHandler: (e: Exception) -> Unit = {}

}

class BotContextImpl : ApiContext {
    override var timeout: Int? = null

    private val webClient: WebClient = TODO()

    private val baseUrl: String = TODO()

    override fun <T: ResultType?> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T?> =
        Future.future { promise ->
            val url = baseUrl + command
            val request = webClient.postAbs(baseUrl)
            val form = MultipartForm.create()
            args.filter { it.second != null }.forEach { (key, value) ->
                when {
                    value is InputFile -> TODO()
                    isSimpleType(value) -> form.attribute(key, value.toString())
                    else -> form.attribute(key, Json.mapper.writeValueAsString(value))
                }
            }
            request.sendMultipartForm(form) {
                if (it.succeeded()){
                    try {
                        val a=it.result().bodyAsString()
                        val r=Json.mapper.readValue<T>(a,resultType)
                        promise.complete(r)
                    }catch (e:Exception){
                        promise.fail(e)
                    }
                }else{
                    promise.fail(it.cause())
                }
            }
        }
}


fun defaultHttpTimeout(command: String, args: List<Pair<String, Any?>>): Int =
    when (command) {
        "getUpdates" -> args.toMap()["timeout"].toString().toInt()
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