package com.dev925.io.util

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.newFixedThreadPoolContext

class AppExecutors {
    companion object {
        val diskIO by lazy {
            newFixedThreadPoolContext(1, "disk")
        }

        val networkIO by lazy {
            newFixedThreadPoolContext(4, "network")
        }

        val channel by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Channel<Any>(capacity = Channel.UNLIMITED)
        }

    }
}