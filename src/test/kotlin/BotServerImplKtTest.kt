import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import types.InputFile

internal class BotServerImplKtTest {
    @Test
    fun testCheckNeedForm() {
        assertTrue(checkNeedForm(BotRequest("", listOf(Pair("", object : InputFile {})))))
        assertFalse(checkNeedForm(BotRequest("", listOf(Pair("", "")))))
    }

    @Test
    fun checkSimpleType() {
        assertTrue(checkSimpleType(""))
        assertTrue(checkSimpleType(0))
        assertTrue(checkSimpleType(true))
        assertTrue(checkSimpleType(null))
        assertFalse(checkSimpleType(emptyArray<Unit>()))
        assertFalse(checkSimpleType(object : InputFile {}))
        assertFalse(checkSimpleType(this))
    }

    @Test
    fun testEncodeToJson() {
        val arr = listOf(Pair("A", "a"), Pair("B", "b"))
        println(encodeToJson(arr))
    }
}