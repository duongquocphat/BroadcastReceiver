package com.shakutara.broadcastreceiver.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.shakutara.broadcastreceiver.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity :
    AppCompatActivity(),
    View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            btnSendBroadcast ->
                sendBroadcastToMainActivity()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnSendBroadcast.setOnClickListener(this)
    }

    private fun sendBroadcastToMainActivity() {
        Intent().also {intent->
            intent.action = "com.duongquocphat.broadcast.MY_NOTIFICATION"
            intent.putExtra("data", "My name is Shakutara")
            sendBroadcast(intent)
        }
    }
}
