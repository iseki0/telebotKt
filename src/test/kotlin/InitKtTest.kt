import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class InitKtTest {

    @Test
    fun testGetObjectMapper() {
        val mapper = getObjectMapper()
        assertTrue(mapper.registeredModuleIds.contains("com.fasterxml.jackson.module.kotlin.KotlinModule"))
        assertFalse { mapper.isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES) }
    }
}