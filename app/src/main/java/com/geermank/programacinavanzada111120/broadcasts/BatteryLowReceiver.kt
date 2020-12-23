package com.geermank.programacinavanzada111120.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.geermank.programacinavanzada111120.extensions.toast

class BatteryLowReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.toast("Te estás quedando sin bateria!! :( ")
    }
}
