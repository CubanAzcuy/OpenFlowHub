package com.dev925.io.networking.rest

import com.dev925.io.networking.util.GsonSource
import com.facebook.stetho.okhttp3.StethoInterceptor

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.atomic.AtomicBoolean

class EntityFactory(baseUrl: String, debug: Boolean) {
    private val mRetrofit: Retrofit

    init {
        val client: OkHttpClient = if (debug) {
            OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .build()
        } else {
            OkHttpClient.Builder()
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .build()
        }

        mRetrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonSource.gson))
                .build()
    }

    fun <T> createService(service: Class<T>): T {
        return mRetrofit.create(service)
    }

    companion object {
        lateinit var instance: EntityFactory
        private val initialised = AtomicBoolean(false)

        fun initialize(baseUrl: String, debug: Boolean = false) {
            synchronized(this) {
                if (initialised.compareAndSet(false, true)) {
                    instance = EntityFactory(baseUrl, debug)
                } else {
                    instance
                }
            }
        }

        fun <T> create(service: Class<T>): T {
            synchronized(this) {
                if (initialised.get()) {
                    return instance.createService(service)
                }

                throw NullPointerException()
            }
        }
    }
    //endregion
}