package com.dev925.openflowhub

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dev925.openflowhub.R.layout.activity_main
import com.dev925.openflowhub.other.UniversalProducer
import com.dev925.openflowhub.service.ForegroundService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.android.UI
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var job1: Job
    lateinit var random: Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        random = Random()
        async(CommonPool) {
            sendMessage("hello")
        }

    }

    suspend fun sendMessage(text: String) {
        var intent = Intent(this, ForegroundService::class.java)
        intent.putExtra("Message", text)
        startService(intent)
    }

    override fun onResume() {
        super.onResume()
        var count = 0

        job1 = async(CommonPool) {
            for(x in UniversalProducer.producer) {
                delay(random.nextInt(10000).toLong())
                count++

                launch(UI) {
                    text.text = "$x $count"
                }

                println("$x Job 1")
                sendMessage("Hello")
            }
        }

        startService(Intent(this, ForegroundService::class.java))
    }

    override fun onPause() {
        super.onPause()
        job1.cancel()
    }
}
