package com.dev925.openflowhub.other

import kotlinx.coroutines.experimental.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

/**
 * Created by robertgross on 5/8/18.
 */

class WebSocketClient(host: String) : WebSocketListener() {
    private val client = OkHttpClient()
    private val connection: WebSocket

    init {
        this.connection = client.newWebSocket(Request.Builder().url(host).build(), this)
    }

    fun send(s: String) {
        connection.send(s)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        super.onMessage(webSocket, text)
        launch {
            onMessage(text!!)
        }
    }

    private suspend fun onMessage(text: String) {
        UniversalProducer.producer.send(text)
    }

}