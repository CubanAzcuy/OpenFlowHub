package com.dev925.openflowhub.websocket

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.dev925.openflowhub.rx.GenericEventBus

/**
 * Created by robertgross on 5/6/18.
 */

class ForegroundService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        GenericEventBus.instance.send("Hello")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        return Service.START_STICKY

    }
}
