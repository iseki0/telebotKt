import io.vertx.core.Future
import io.vertx.core.json.JsonObject

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)


class BotContext(val botServer: BotServer) {

    inline fun <reified R> awsl(req: BotRequest): Future<R?> = Future.future { promise ->
        botServer.sendRequest(req).setHandler {
            if (it.succeeded()) {
                val a = it.result().getValue("result")
                if (0 is R) {
                    // if R is integer
                    promise.complete(a as R)
                } else if ("" is R) {
                    // if R is string
                    promise.complete(a as R)
                } else if (true is R) {
                    // if R is boolean
                    //  if result is boolean
                    //      return result as boolean
                    //  else return TRUE
                    if (a is Boolean) {
                        promise.complete(a as R)
                    } else {
                        promise.complete(true as R)
                    }
                } else {
                    promise.complete((a as? JsonObject)?.mapTo(R::class.java))
                }
            } else {
                promise.fail(it.cause())
            }
        }
    }

    inline fun <reified R> awslByArray(req: BotRequest): Future<Array<R>?> = Future.future { promise ->
        botServer.sendRequest(req).setHandler {
            if (it.succeeded()) {
                val arr = it.result().getJsonArray("result").map {
                    (it as JsonObject).mapTo(R::class.java)
                }.toTypedArray()
                promise.complete(arr)
            } else {
                promise.fail(it.cause())
            }
        }
    }

    inline fun xswl(req: BotRequest): Future<Any> = Future.future { promise ->
        botServer.sendRequest(req).setHandler {
            if (it.succeeded()) {
                promise.complete(it.result().getValue("result"))
            } else {
                promise.fail(it.cause())
            }
        }
    }


}