package api

import api.Either.Right
import api.type.Poll
import api.type.PollOption
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind.node.BooleanNode
import com.fasterxml.jackson.databind.ser.ContextualSerializer
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.vertx.core.json.Json
import io.vertx.core.json.JsonObject
import parseResult
import kotlin.reflect.KClass
import kotlin.reflect.KClassifier
import kotlin.reflect.full.allSupertypes
import kotlin.reflect.full.createType
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaType
import kotlin.reflect.jvm.jvmErasure


fun main() {
    Json.mapper.registerKotlinModule()
    Json.prettyMapper.registerKotlinModule()

    val poll = Poll(id = "abc", question = "ques", isClosed = false, options = listOf(PollOption("a", 1)))
    val json = Json.mapper.writeValueAsString(poll)
    //println(json)
    //println(Json.mapper.readValue(json,Poll::class.java))
    //println(Poll::class.memberProperties.toList()[2].returnType.arguments)

    val a = aaaa<Either<String, Int>>(object : AAAR<Either<String, Int>> {})

    //val e:Either<PollOption,String>? = parseResult("""{"ok":true,"result":"""+JsonObject.mapFrom(PollOption(text = "aaaaa",voterCount = 1)).toString()+"}",object :api.TypeReference<Either<PollOption,String>>{})
}

fun <T> aaaa(t: AAAR<out T>): T? {
    val a =
        t::class.supertypes.find { it.classifier == AAAR::class }!!.arguments[0].type!!.classifier
    println(a as Class<*>)
    println(a == Either::class)
    //Json.mapper.readValue("",a)
    TODO()
}

interface AAAR<T>
