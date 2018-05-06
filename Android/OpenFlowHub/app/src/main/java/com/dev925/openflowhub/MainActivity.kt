package com.dev925.openflowhub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dev925.openflowhub.rx.GenericEventBus
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GenericEventBus.instance.observable
                .subscribeOn(Scheduler.)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    println(it)
                    //     rxWebSockets.sendMessage("Hello")
                }
    }
}
