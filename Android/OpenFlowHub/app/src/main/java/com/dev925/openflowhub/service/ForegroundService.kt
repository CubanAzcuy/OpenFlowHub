package com.dev925.openflowhub.service

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
        GenericEventBus.instance.send("Robert's Test App")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        return Service.START_STICKY

    }
}
