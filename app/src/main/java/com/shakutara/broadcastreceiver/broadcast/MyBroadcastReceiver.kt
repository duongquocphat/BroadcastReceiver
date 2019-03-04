package com.shakutara.broadcastreceiver.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import java.lang.StringBuilder

class MyBroadcastReceiver(var myBroadcastReceiverListener: MyBroadcastReceiverListener) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        StringBuilder().apply {
            append("Action: ${intent.action}\n")
            append("URI: ${intent.toUri(Intent.URI_INTENT_SCHEME)}\n")
            toString().also { log ->
                myBroadcastReceiverListener.getDataFromMyBroadcastReceiver(intent.getStringExtra("data"))
            }
        }
    }

    ///////////

    interface MyBroadcastReceiverListener {
        fun getDataFromMyBroadcastReceiver(data: String)
    }

    ///////////
}