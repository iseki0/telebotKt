import io.vertx.core.json.JsonObject

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
    aa<String?>()
    println("========")
    aa1<Boolean?>()

    val a = JsonObject("""{"a":"sss"}""")
    println(a.getValue("a").javaClass)
}

fun aaa(): BotServer = TODO()