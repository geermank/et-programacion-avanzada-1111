package com.geermank.programacinavanzada111120.services

import android.app.IntentService
import android.content.Intent
import android.util.Log

class TimerIntentService : IntentService("TimerIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("TimerIntentService", "Tarea iniciada")
        Thread.sleep(5000)
        Log.i("TimerIntentService", "Tarea finalizada")
    }
}
