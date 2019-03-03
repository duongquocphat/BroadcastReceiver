package com.shakutara.broadcastreceiver.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.lang.StringBuilder

class MyBroadcastReceiver : BroadcastReceiver() {

    private val TAG = MyBroadcastReceiver::class.java.simpleName

    override fun onReceive(context: Context?, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                Log.d(TAG, intent.getStringExtra("data"))
                Toast.makeText(context, log, Toast.LENGTH_SHORT).show()
            }
        }
    }
}