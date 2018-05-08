package com.dev925.openflowhub.other

import kotlinx.coroutines.experimental.channels.Channel

/**
 * Created by robertgross on 5/8/18.
 */

class UniversalProducer {
    companion object {
        val producer by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Channel<String>(capacity = Channel.UNLIMITED)
        }
    }
}