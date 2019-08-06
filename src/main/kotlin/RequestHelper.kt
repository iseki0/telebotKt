import io.vertx.core.Future
import io.vertx.core.json.JsonObject


data class BotRequest(val api: String, val jsonObject: JsonObject)


class BotContext(val botServer: BotServer) {

    inline fun <reified BasicType, reified ObjectType> awslByEither(req: BotRequest): Future<Either<BasicType, ObjectType>?> =
        botServer.sendRequest(req).compose<Either<BasicType, ObjectType>?> {
            val basicType = BasicType::class.java
            val result = it.getValue("result") ?: return@compose Future.succeededFuture(null)
            when {
                basicType.isInstance(result) -> Future.succeededFuture(Either.Left(result as BasicType))
                else -> Future.succeededFuture(Either.Right((result as JsonObject).mapTo(ObjectType::class.java)))
                //else -> throw RuntimeException("awslByEither: left = $basicType, right = $objectType, result = ${result::class.java}")
            }
        }

    inline fun <reified R> awsl(req: BotRequest): Future<R?> =
        botServer.sendRequest(req).compose {
            val type = R::class.java
            val a = it.getValue("result")
            Future.succeededFuture(
                when {
                    type.isInstance(true) ->
                        a as R
                    type.isInstance("") ->
                        a as R
                    type.isInstance(0) ->
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