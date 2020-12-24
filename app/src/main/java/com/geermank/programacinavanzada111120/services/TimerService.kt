package com.geermank.programacinavanzada111120.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.geermank.programacinavanzada111120.R

class TimerService : Service() {

    companion object {
        const val START = "TimerServiceStart"
        const val END = "TimerServiceEnd"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("TimerService", "Temporizador creado")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("TimerService", "Componente enlazado")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(1, getNotification())
        Thread {
            Log.i("TimerService", "Tarea iniciada")
            notifyBroadcast(START)
            Thread.sleep(5000)
            Log.i("TimerService", "Tarea finalizada")
            notifyBroadcast(END)
            stopSelf(startId)
        }.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TimerService", "Temporizador destruido")
    }

    private fun getNotification(): Notification? {
        val builder = NotificationCompat.Builder(this, "temporizador-id")
            .setContentTitle("Temporizador en curso")
            .setContentText("Tiempo de espera: 5 segundos")
            .setSmallIcon(R.mipmap.ic_launcher)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel("temporizador-id", "Temporizador", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        return builder.build()
    }

    private fun notifyBroadcast(action: String) {
        val intent = Intent(action)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}
