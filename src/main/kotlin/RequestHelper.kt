import io.vertx.core.Future
import io.vertx.core.json.JsonObject


data class BotRequest(val api: String, val jsonObject: JsonObject)


class BotContext(val botServer: BotServer) {

    inline fun <reified BasicType, reified ObjectType> awslByEither(req: BotRequest): Future<Either<BasicType, ObjectType>?> =
        botServer.sendRequest(req).compose<Either<BasicType, ObjectType>?> {
            when (it.getValue("result") ?: return@compose Future.succeededFuture(null)) {
                is BasicType -> Future.succeededFuture(Either.Left(it as BasicType))
                is ObjectType -> Future.succeededFuture(Either.Right((it as JsonObject).mapTo(ObjectType::class.java)))
                else -> throw RuntimeException()
            }
        }

    inline fun <reified R> awsl(req: BotRequest): Future<R?> =
        botServer.sendRequest(req).compose {
            val a = it.getValue("result")
            Future.succeededFuture(
                when {
                    0 is R ->
                        a as R
                    "" is R ->
                        a as R
                    true is R ->
                        a as R
                    else -> (a as? JsonObject)?.mapTo(R::class.java)
                }
            )
        }


    inline fun <reified R> awslByArray(req: BotRequest): Future<Array<R>?> =
        botServer.sendRequest(req).compose {
            Future.succeededFuture(it.getJsonArray("result")?.map {
                (it as JsonObject).mapTo(R::class.java)
            }?.toTypedArray())
        }
}

fun genBotRequest(api: String, vararg pairs: Pair<String, Any?>): BotRequest =
    BotRequest(api, JsonObject(mapOf(*pairs).filterNot { it.value == null }))