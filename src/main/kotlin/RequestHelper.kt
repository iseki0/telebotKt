import io.vertx.core.Future
import io.vertx.core.json.JsonObject

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))

data class BotRequest(val api: String, val jsonObject: JsonObject)


class BotContext(val botServer: BotServer) {


    inline fun <reified BasicType, reified ObjectType> awslByEither(req: BotRequest): Future<Either<BasicType, ObjectType>?> =
        Future.future { promise ->
            botServer.sendRequest(req).setHandler {
                if (it.succeeded()) {
                    val a = it.result().getValue("result") ?: promise.complete(null)
                    when (a) {
                        is BasicType -> promise.complete(Either.Left(a as BasicType))
                        is ObjectType -> promise.complete(Either.Right((a as JsonObject).mapTo(ObjectType::class.java)))
                    }
                } else {
                    promise.fail(it.cause())
                }
            }
        }

    inline fun <reified R> awsl(req: BotRequest): Future<R?> = Future.future { promise ->
        botServer.sendRequest(req).setHandler {
            if (it.succeeded()) {
                val a = it.result().getValue("result")
                when {
                    0 is R -> // if R is integer
                        promise.complete(a as R)
                    "" is R -> // if R is string
                        promise.complete(a as R)
                    true is R -> promise.complete(a as R)
                    else -> promise.complete((a as? JsonObject)?.mapTo(R::class.java))
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