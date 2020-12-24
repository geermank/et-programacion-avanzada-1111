package com.geermank.programacinavanzada111120.broadcasts

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.geermank.programacinavanzada111120.BaseActivity
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.activity_battery_low.*

class BatteryLowActivity : BaseActivity(), OnChargeLevelChangedListener {

    private val intentFilter = IntentFilter()
    private val batteryChargeLevelReceiver = BatteryChargeLevelReceiver(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_low)
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(batteryChargeLevelReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(batteryChargeLevelReceiver)
    }

    override fun onChargeLevelChanged(level: Int) {
        tv_battery_level.text = "Porcentaje de batería restante: $level%"
    }
}
