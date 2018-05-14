package com.dev925.io.networking.socket

import com.dev925.io.util.AppExecutors
import kotlinx.coroutines.experimental.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketClient(host: String) : WebSocketListener() {
    private val client = OkHttpClient()
    private val connection: WebSocket

    init {
        val request = Request.Builder().url(host).build();
        this.connection = client.newWebSocket(request, this)
    }

    fun send(s: String) {
        connection.send(s)
    }

    override fun onMessage(webSocket: WebSocket?, text: String?) {
        super.onMessage(webSocket, text)
        launch {
            text?.let {
                onMessage(it)
            }
        }
    }

    private suspend fun onMessage(text: String) {
        AppExecutors.channel.send(text)
    }

}