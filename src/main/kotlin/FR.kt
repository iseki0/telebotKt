import deserializer.registerObjectMapperModule
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClientOptions
import io.vertx.core.json.Json
import io.vertx.core.net.ProxyOptions
import io.vertx.core.net.ProxyType

inline fun <reified T> aa() {
    println("" is T)
    println(String is T)
    println(java.lang.Object().toString() is T)
    println(java.lang.String.valueOf(1) is T)
    println(java.lang.String.valueOf(1) is String)
}

inline fun <reified T> aa1() {
    println(true is T)
    println(Boolean is T)
    println(java.lang.Boolean.FALSE is T)
    println(java.lang.Boolean.parseBoolean("true") is T)
    println("true".toBoolean() is T)
}

fun main() {
    registerObjectMapperModule(Json.prettyMapper)
    registerObjectMapperModule(Json.mapper)
    val vertx = Vertx.vertx()
    val botServer = BotServer.create(
        vertx = vertx,
        botConfig = BotConfig(
            botKey = "981517466:AAHpynMZZ8oItS_-S_n8me1OQiTPa1criUM"
        ),
        httpClient = vertx.createHttpClient(
            HttpClientOptions().setProxyOptions(
                ProxyOptions().setType(ProxyType.SOCKS5).setHost(
                    "127.0.0.1"
                ).setPort(17654)
            )
        )
    )
    botServer.start().setHandler {
        println(it)
    }
}

