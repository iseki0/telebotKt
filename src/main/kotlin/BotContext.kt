import io.vertx.core.Future
import io.vertx.core.json.JsonObject

class BotContext(
    val botServer: BotServer,
    val httpTimeout: Int
)

inline fun <reified BasicType, reified ObjectType> BotContext.awslByEither(req: BotRequest): Future<Either<BasicType, ObjectType>?> =
    botServer.sendRequest(req, this).compose<Either<BasicType, ObjectType>?> {
        val basicType = BasicType::class.java
        val result = it.getValue("result") ?: return@compose Future.succeededFuture(null)
        Future.succeededFuture(
            if (basicType.isInstance(result))
                Either.Left(result as BasicType)
            else
                Either.Right((result as JsonObject).mapTo(ObjectType::class.java))
        )
    }

inline fun <reified R> BotContext.awsl(req: BotRequest): Future<R?> =
    botServer.sendRequest(req, this).compose {
        val type = R::class.java
        val a = it.getValue("result")
        Future.succeededFuture(
            if (basicTypeNeednotMapTo(type))
                a as R
            else
                (a as? JsonObject)?.mapTo(R::class.java)
        )
    }

inline fun <reified R> BotContext.awslByArray(req: BotRequest): Future<Array<R>?> =
    botServer.sendRequest(req, this).compose {
        Future.succeededFuture(it.getJsonArray("result")?.map {
            (it as JsonObject).mapTo(R::class.java)
        }?.toTypedArray())
    }