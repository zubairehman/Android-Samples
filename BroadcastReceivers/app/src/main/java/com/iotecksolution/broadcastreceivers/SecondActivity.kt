package com.iotecksolution.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.iotecksolution.broadcastreceivers.receivers.ExampleBroadcastReceiver

class SecondActivity : AppCompatActivity() {

    private val exampleReceiver = ExampleBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
//        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        registerReceiver(exampleReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
//        unregisterReceiver(exampleReceiver)
    }

    fun sendBroadcast(view: View) {
        // Sample: 1
        // if the broadcast has been called by using class name (explicitly), then it doesn't
        // care about intent filter. Such a broadcast if explicit broadcast
//        val intent = Intent(this, ExampleBroadcastReceiver::class.java)
//        intent.action = "com.zubair.action.TEST"
//        sendBroadcast(intent)


        // Sample 2:
        // However if we trigger a broadcast using intent filter then it has to match the exact filter
        // mentioned while registering the receiver (either in manifest or code) else the receiver
        // wont be called
        // Note: Implicit broadcasts won't work Android api level 7.0+ (Nougat), for that you need
        // to register your receivers dynamically (explicit broadcast)
        val intent = Intent("com.zubair.action.TEST1")
        sendBroadcast(intent)
    }

    fun registerDynamicBroadcast(view: View) {
        val intentFilter = IntentFilter("com.zubair.action.TEST1")
        registerReceiver(exampleReceiver, intentFilter)
    }

    fun unregisterDynamicReceiver(view: View) {
        // in-order to un-register receiver you can either create a singleton ReceiverManager which
        // will hold a list of receivers and convenience methods to register/unregister receiver.
        // The other solution might be to have convenience methods to register/unregister in each
        // broadcast receiver and have a boolean check to determine if its already registered
        // Note: If you are registering a broadcast receiver dynamically then make sure to un-register
        // it in its fellow method onCreate() -> onDestroy()
        unregisterReceiver(exampleReceiver)
    }


}
