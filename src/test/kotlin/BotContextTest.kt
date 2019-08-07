import deserializer.registerObjectMapperModule
import io.vertx.core.Future
import io.vertx.core.json.Json
import io.vertx.core.json.JsonObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import types.*


internal class BotContextTest {
    val botRequest = BotRequest("testAPI", JsonObject("""{"key": "value"}"""))
    val botServer = object : BotServer {
        override fun sendRequest(req: BotRequest): Future<JsonObject> =
            Future.succeededFuture(this@BotContextTest.result)//.apply { println(result().encodePrettily()) }
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
        //println(result)
        botContext.stopMessageLiveLocation().setHandler {
            it.cause()?.printStackTrace()
            assertTrue(it.succeeded())
            assertEquals(msg, (it.result() as Either.Right).b)
        }
    }

    @Test
    fun testAwslByArray() {
        val chatm = arrayOf(
            ChatMember(user = User(id = 1, isBot = false, firstName = "f1"), status = ChatMemberStatus.KICKED),
            ChatMember(user = User(id = 2, isBot = true, firstName = "bot"), status = ChatMemberStatus.ADMINISTRATOR)
        )
        result = JsonObject.mapFrom(object {
            val ok = true
            val result = chatm
        })

        result.getJsonArray("result").map {
            val o = it as JsonObject
            //println(o.encodePrettily())
            o.mapTo(ChatMember::class.java)
        }
        //println(result)
        botContext.getChatAdministrators("111").setHandler {
            it.cause()?.printStackTrace()
            assertTrue(it.succeeded())
            assertArrayEquals(chatm, it.result())
        }
    }


    data class TestTypeAwsl(
        val aaa: String = "testValue"
    )

    @BeforeEach
    fun i() {
        register()
    }

    companion object {
        var begins = false
    }

}

var moduleRegistered = false
fun register() {
    if (!moduleRegistered) {
        moduleRegistered = true
        registerObjectMapperModule(Json.mapper)
        registerObjectMapperModule(Json.prettyMapper)
        println("Module registered!")
    }
}