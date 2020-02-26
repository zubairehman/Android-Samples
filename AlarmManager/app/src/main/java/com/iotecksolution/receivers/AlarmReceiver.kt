package com.iotecksolution.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.util.Log
import android.widget.Toast


class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("AlarmManager", "Alarm Received")
        Toast.makeText(context, "Alarm received", Toast.LENGTH_SHORT).show()

        val wakeLock: PowerManager.WakeLock =
            (context?.getSystemService(Context.POWER_SERVICE) as PowerManager).run {
                newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "MyApp::MyWakelockTag").apply {
                    acquire(1000)
                }
            }
        wakeLock.acquire(1000)
    }
}