package com.geermank.programacinavanzada111120

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geermank.programacinavanzada111120.broadcasts.BatteryLowReceiver

abstract class BaseActivity : AppCompatActivity() {

    private val intentFilter = IntentFilter()
    private val batteryLowReceiver = BatteryLowReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(batteryLowReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryLowReceiver)
    }
}
