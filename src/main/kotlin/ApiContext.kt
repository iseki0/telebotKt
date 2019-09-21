import api.ResultType
import io.vertx.core.Future
import java.math.BigInteger
import kotlin.system.measureTimeMillis

interface ApiContext {
    fun <T : ResultType> doSendRequest(
        command: String,
        args: List<Pair<String, Any?>>,
        resultType: Class<T>
    ): Future<T>
}

fun main(){
    var a=BigInteger("0")
    var b=BigInteger("1")
    measureTimeMillis {
        repeat(10_0000){
            val t=a
            a=b
            b=a+t
        }
    }.apply { println(this) }
    println(b)
}