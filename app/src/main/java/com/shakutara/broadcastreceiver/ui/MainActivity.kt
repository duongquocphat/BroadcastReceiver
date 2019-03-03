package com.shakutara.broadcastreceiver.ui

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.shakutara.broadcastreceiver.R
import com.shakutara.broadcastreceiver.broadcast.MyBroadcastReceiver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :
    AppCompatActivity(),
    View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            button ->
                moveToMain2Activity()
        }
    }

    private fun moveToMain2Activity() {
        val intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    private val br: BroadcastReceiver = MyBroadcastReceiver()
    private val filter = IntentFilter("com.duongquocphat.broadcast.MY_NOTIFICATION")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerReceiver(br, filter, Manifest.permission.READ_CONTACTS, null)

        // views click
        button.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}
