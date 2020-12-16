package com.geermank.programacinavanzada111120.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TimerService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.i("TimerService", "Temporizador creado")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("TimerService", "Componente enlazado")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread {
            Log.i("TimerService", "Tarea iniciada")
            Thread.sleep(5000)
            Log.i("TimerService", "Tarea finalizada")
            stopSelf(startId)
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TimerService", "Temporizador destruido")
    }
}
