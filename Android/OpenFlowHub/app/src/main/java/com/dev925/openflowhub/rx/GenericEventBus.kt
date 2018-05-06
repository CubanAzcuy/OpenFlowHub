package com.dev925.openflowhub.rx

import com.jakewharton.rxrelay2.ReplayRelay
import io.reactivex.Observable

/**
 * Created by robertgross on 5/6/18.
 */

class GenericEventBus {
    private val bus = ReplayRelay.create<Any>().toSerialized()
    val observable: Observable<Any>
        @Synchronized get() {
            return bus
        }

    @Synchronized fun send(o: Any) {
        bus.accept(o)
    }

    companion object {
        var instance: GenericEventBus = GenericEventBus()
            @Synchronized get() {
                return field
            }
            @Synchronized set(value) {
                field = value
            }
    }
}