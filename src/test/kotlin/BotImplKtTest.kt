import api.GetUpdatesResult
import api.func.getUpdates
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerOptions
import io.vertx.ext.web.client.WebClientOptions
import io.vertx.junit5.VertxExtension
import io.vertx.junit5.VertxTestContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


const val LOCAL_PORT = 17922

@ExtendWith(VertxExtension::class)
internal class BotImplKtTest {

    @Test
    fun testDoRequestSend(vertx: Vertx, testContext: VertxTestContext) {

        vertx.createHttpServer(HttpServerOptions().setPort(LOCAL_PORT)).requestHandler {
            it.body { println(it.toString()) }
            it.response().end(
                """
                {
                  "ok": true,
                  "result": []
                }
            """.trimIndent()
            ) {
            }
        }.listen {
            testContext.verify { assertTrue(it.succeeded()) }
            val bot = BotImpl(
                botOption = BotOption(
                    botKey = "testkey",
                    webClientOptions = WebClientOptions(),
                    botServerInfo = BotServerInfo(urlGenerator = { botKey: String, api: String -> "http://127.0.0.1:$LOCAL_PORT/bot$botKey/$api" })
                ),
                vertx = vertx
            )
            bot.getUpdates(offset = 555, limit = 50, timeout = 80) {
                testContext.succeeding<GetUpdatesResult> {
                    testContext.verify {
                        assertEquals(
                            GetUpdatesResult(
                                ok = true,
                                result = emptyList(),
                                errorCode = null,
                                description = null
                            ), it
                        )
                        println(it)
                        vertx.close()
                        testContext.completeNow()
                    }
                }.handle(it)
            }
        }

    }

    @Test
    fun defaultTimeout() {
        assertEquals(35 * 1000L, defaultTimeout("getUpdates", listOf(Pair("timeout", 30))))
        assertEquals(30 * 1000L, defaultTimeout("bhbhb", emptyList()))
        assertEquals(30 * 1000L, defaultTimeout("getUpdates", emptyList()))
    }

}