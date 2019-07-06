package deserializer

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

class FieldExistDeserializer<T>(private val typeClass: Class<T>, val list: List<Class<out T>>) :
    StdDeserializer<T>(typeClass) {
    private val map = list.map { clazz ->
        clazz.constructors.filter { it.isAnnotationPresent(JsonCreator::class.java) }
            .map { it.parameterAnnotations }
            .flatMap { it.toList() }
            .flatMap { it.toList() }
            .filterIsInstance<JsonProperty>()
            .map { it.value }
            .distinct()
            .map { Pair(it, clazz) }
    }.flatten()
        .groupBy { it.first }
        .filter { it.value.size == 1 }
        .map { Pair(it.key, it.value.last().second) }.toMap()

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): T? {
        requireNotNull(p)
        val root = p.readValueAsTree<TreeNode>() ?: return null
        val clazz = run {
            root.fieldNames().forEach {
                map[it]?.let { return@run it }
            }
            throw UndeterminedDeserializationType()
        }
        val mapper = p.codec as ObjectMapper
        return mapper.treeToValue(root, clazz)
    }

    companion object {
        inline fun <reified BaseType> create(list: List<Class<out BaseType>>): FieldExistDeserializer<BaseType> =
            FieldExistDeserializer(BaseType::class.java, list)
    }
}


