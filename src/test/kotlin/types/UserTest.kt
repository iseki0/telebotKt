package types

import io.vertx.core.json.JsonObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import register

internal class UserTest {

    val serializedJson = """{"id":123,"is_bot":true,"first_name":"testName"}""".trim()

    val testObject = User(
        id = 123,
        isBot = true,
        firstName = "testName"
    )

    @BeforeEach
    fun i() {
        register()
    }

    @Test
    fun testSerialization() {
        assertEquals(serializedJson, JsonObject.mapFrom(testObject).encode())
    }

    @Test
    fun testDeserialization() {
        assertEquals(testObject, JsonObject(serializedJson).mapTo(User::class.java))
    }
}