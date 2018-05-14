package com.dev925.io.networking.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.*

class GsonSource {
    companion object {
        val gson: Gson by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            val gsonBuilder = GsonBuilder()
            gsonBuilder.registerTypeAdapter(Date::class.java, DateSerializer())
            gsonBuilder.create()
        }
    }
}