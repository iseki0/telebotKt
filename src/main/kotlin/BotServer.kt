import api.ApiContext
import api.Either
import api.InputFile
import api.TypeReference
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

    override fun <T> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: TypeReference<*>
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
                try {
                    parseResult<T>(it.result().bodyAsString(),resultType)
                } catch (e: Exception) {
                    promise.fail(e)
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

class TelegramRequestException(val errorCode: Int, val description: String) :
    RuntimeException("$errorCode - $description")


fun <T> parseResult(str:String,resultType:TypeReference<*>):T?{
    val mapper=Json.mapper
    val resultTree=mapper.readTree(str)
    if (resultTree.get("ok").asBoolean()) {
        val type=resultType::class.supertypes.find { it.classifier==TypeReference::class }!!.arguments[0]!!.type!!
        if (type.classifier == Either::class){
            val l=type.arguments[0].type!!.classifier as Class<*> // object type
            val r=type.arguments[1].type!!.classifier as Class<*> // simple type
            if (resultTree["result"].isPojo){
                return Either.Left( mapper.readValue(mapper.treeAsTokens(resultTree["result"]),l)) as T
            }
        }else{

        }

    }else{
        throw TelegramRequestException(resultTree.get("error_code").asInt(),resultTree.get("description").asText())
    }
    TODO()
}