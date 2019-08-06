import io.vertx.core.Future
import io.vertx.core.json.JsonObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import types.Chat
import types.ChatType
import types.Message


internal class BotContextTest {
    val botRequest = BotRequest("testAPI", JsonObject("""{"key": "value"}"""))
    val botServer = object : BotServer {
        override fun sendRequest(req: BotRequest): Future<JsonObject> =
            Future.succeededFuture(this@BotContextTest.result)
    }
    val botContext = BotContext(botServer)
    private lateinit var result: JsonObject

    @Test
    fun testAwsl() {
        val a = TestTypeAwsl()
        result = JsonObject.mapFrom(object {
            val ok = true
            val result = a
        })
        botContext.awsl<TestTypeAwsl>(botRequest).setHandler {
            assertTrue(it.succeeded())
            assertEquals(a, it.result())
        }
    }

    @Test
    fun testAwsl2() {
        result = JsonObject("""{"result": true}""")
        botContext.setWebhook("aaa").setHandler {
            assertTrue(it.succeeded())
            assertTrue(it.result()!!)
        }
    }

    @Test
    fun testAwslByEither() {
        val msg = Message(
            chat = Chat(id = 123, type = ChatType.CHANNEL),
            date = 456,
            messageId = 789
        )
        result = JsonObject.mapFrom(object {
            val ok = true
            val result = msg
        })
        //assertEquals(msg,JsonObject("""{"date":456,"chat":{"id":123,"type":"channel"},"messageId":789}""").mapTo(Message::class.java))
        botContext.stopMessageLiveLocation().setHandler {
            it.cause()?.printStackTrace()
            assertTrue(it.succeeded())
            assertEquals(msg, (it.result() as Either.Right).b)
        }
    }


    data class TestTypeAwsl(
        val aaa: String = "testValue"
    )

}