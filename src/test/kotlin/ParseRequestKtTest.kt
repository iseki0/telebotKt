import api.InputFile
import api.ParseMode
import com.fasterxml.jackson.databind.ObjectMapper
import io.vertx.core.Vertx
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class ParseRequestKtTest {

    val server = object : Bot {
        override val botOption: BotOption
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val vertx: Vertx
            get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        override val mapper: ObjectMapper = getObjectMapper()
    }

    @Test
    fun createRequest() {
        val list = listOf(
            Pair("a", "b"),
            Pair("int", 123),
            Pair("null", null),
            Pair("long", 100L),
            Pair("fileid", InputFile(fileId = "fileid")),
            Pair("list", listOf(ParseMode.HTML, ParseMode.MARKDOWN)),
            Pair("obj", object {
                val a = "a";
                val b = "b"
            })
        )

        val sourceList = server.fillRequestForm(list).map {
            "${it.name()} ${it.isAttribute} ${it.isFileUpload} ${it.isText} ${it.filename()} ${it.value()}"
        }
        sourceList.forEach { println(it) }
        val targetList = listOf(
            """a true false null null b""",
            """int true false null null 123""",
            """long true false null null 100""",
            """fileid true false null null fileid""",
            """list true false null null ["HTML","Markdown"]""",
            """obj true false null null {"a":"a","b":"b"}"""
        )
        assertEquals(sourceList, targetList)
    }

    @Test
    fun isSimpleType() {
        assertTrue(isSimpleType("String"))
        assertTrue(isSimpleType(123))
        assertTrue(isSimpleType(123L))
        assertTrue(isSimpleType(0.1))
        assertTrue(isSimpleType(0.1f))

        assertFalse(isSimpleType(object {}))
        assertFalse(isSimpleType(this))
    }

    @Test
    fun detectMIME() {
        val mime = detectMIME(InputFile(file = File("a.jpg")))
        assertEquals("image/jpeg", mime)
    }
}