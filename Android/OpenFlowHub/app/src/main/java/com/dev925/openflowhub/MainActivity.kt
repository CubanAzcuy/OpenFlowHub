package com.dev925.openflowhub

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dev925.openflowhub.R.layout.activity_main
import com.dev925.openflowhub.rx.GenericEventBus
import com.dev925.openflowhub.service.ForegroundService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        GenericEventBus.instance.observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    text.text = it as String
                }
    }

    override fun onResume() {
        super.onResume()
        startService(Intent(this, ForegroundService::class.java))
    }
}
