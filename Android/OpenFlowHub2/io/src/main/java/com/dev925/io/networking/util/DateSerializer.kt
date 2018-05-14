package com.dev925.io.networking.util

import com.dev925.io.util.DateFormatter
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer

import java.lang.reflect.Type
import java.util.Date

class DateSerializer : JsonSerializer<Date>, JsonDeserializer<Date> {

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, arg1: Type, arg2: JsonDeserializationContext): Date {
        val dateString = element.asString
        return DateFormatter.dateFormat.parse(dateString)
    }

    override fun serialize(src: Date, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(DateFormatter.dateFormat.format(src))
    }

}
