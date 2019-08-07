package types

import io.vertx.core.json.JsonObject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import register

internal class StickerSetTest {

    val testObject = StickerSet(
        name = "TestStickerSet",
        title = "Title",
        isAntimated = true,
        containsMasks = false,
        stickers = emptyArray()
    )

    val serializedJson =
        """{"name":"TestStickerSet","title":"Title","is_animated":true,"contains_masks":false,"stickers":[]}""".trim()

    @Test
    fun testSerialization() {
        assertEquals(serializedJson, JsonObject.mapFrom(testObject).encode())
    }

    @Test
    fun testDeserialization() {
        assertEquals(testObject, JsonObject(serializedJson).mapTo(StickerSet::class.java))
    }

    @BeforeEach
    fun i() {
        register()
    }
}