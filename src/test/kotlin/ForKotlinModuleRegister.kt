import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class ForKotlinModuleRegister {
    @Test
    fun testKotlinModule() {
        val mapper = ObjectMapper()
        assertFalse(mapper.registeredModuleIds.contains("com.fasterxml.jackson.module.kotlin.KotlinModule"))
        mapper.registerKotlinModule()
        assertTrue(mapper.registeredModuleIds.contains("com.fasterxml.jackson.module.kotlin.KotlinModule"))
    }
}