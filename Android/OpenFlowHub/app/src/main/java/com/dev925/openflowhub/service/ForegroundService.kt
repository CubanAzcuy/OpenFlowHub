package com.dev925.openflowhub.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.dev925.openflowhub.other.WebSocketClient

/**
 * Created by robertgross on 5/6/18.
 */

class ForegroundService : Service() {

    lateinit var client: WebSocketClient

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        client = WebSocketClient("wss://echo.websocket.org")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        intent?.let {
            onHandleIntent(it)
        }
        return Service.START_STICKY
    }

    private fun onHandleIntent(intent: Intent) {
        var message = intent.getStringExtra("Message")
        message?.let {
            client.send(it)
        }
    }
}
