package com.geermank.programacinavanzada111120

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager

interface OnChargeLevelChangedListener {
    fun onChargeLevelChanged(level: Int)
}

class BatteryChargeLevelReceiver(private val callback: OnChargeLevelChangedListener) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { notNullIntent ->
            val level = notNullIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            callback.onChargeLevelChanged(level)
        }
    }
}