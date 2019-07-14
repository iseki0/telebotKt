package deserializer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

/**
 * *Attention!* This Deserializer is *not* thread safe.
 * If it will shared between multiple thread. *Must* create it in initialize time.
 */
class DDDeserializer<T>(private val baseClass: Class<out T>, private val list: List<Class<out T>>) :
    StdDeserializer<T>(baseClass) {

    private val clsList = list.map {
        val map = HashMap<String, String?>()
        it.constructors.find { it.isAnnotationPresent(JsonCreator::class.java) }
            ?.parameters?.filter { it.isAnnotationPresent(JsonProperty::class.java) }
            ?.forEach {
                val mustBe = it.getAnnotation(ValueMustBe::class.java)?.value
                val name = it.getAnnotation(JsonProperty::class.java).value
                map[name] = mustBe
            }
        Pair(map, it)
    }

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): T? {
        println("asasaas")
        requireNotNull(p)
        requireNotNull(ctxt)
        val maybe = HashSet<Class<out T>>()
        val mustnot = HashSet<Class<out T>>()
        val root = p.readValueAsTree<JsonNode>() ?: return null
        root.fieldNames().forEach outer@{ field ->
            clsList.forEach inner@{ (map, cls) ->
                if (!map.contains(field)) {
                    maybe.remove(cls)
                    mustnot.add(cls)
                }
                if (mustnot.contains(cls)) {
                    return@inner
                }
                val aa = map[field]
                if (aa != null) {
                    if (root[field].toString() == aa) {
                        maybe.add(cls)
                    } else {
                        maybe.remove(cls)
                        mustnot.add(cls)
                    }
                } else {
                    maybe.add(cls)
                }
            }
        }
        val mapper = p.codec as ObjectMapper
        maybe.forEach {
            try {
                return mapper.treeToValue(root, it)
            } catch (e: Exception) {
            }
        }
        throw UndeterminedDeserializationType()
    }

    companion object {
        inline fun <reified T> create(list: List<Class<out T>>): DDDeserializer<out T> =
            DDDeserializer(T::class.java, list)
    }
}