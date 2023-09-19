package kr.mastre.playlist.data

import io.kotest.core.spec.style.FunSpec
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class FirebasePlayItemDtoTest : FunSpec({
    test("Parsing !! uri : xx") {
        val dto = FirebasePlayItemDto("xx")
        val string = Json.encodeToString(dto)
        println(string)
        val raw = """{"uri" : "xx"}"""
        val r = Json.decodeFromString<FirebasePlayItemDto>(raw)
        println(r)
    }

    test("JsonArray to uris") {
        val raw = """{ "playlist" : [{"uri" : "xx"}, {"uri" : "yy"}, {"uri" : "zz"}]}"""
//        val r = Json.parseToJsonElement(raw)
//        println(r.jsonObject["playlist"]?.jsonArray?.map { Json.decodeFromJsonElement<FirebasePlayItemDto>(it) })
        val x = Json.decodeFromString<GetPlayListResponse>(raw)
        println(x)
    }
})
