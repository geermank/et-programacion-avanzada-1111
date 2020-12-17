package com.geermank.programacinavanzada111120.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class ChronometerService : Service() {

    private val binder = ChronometerBinder()

    private var startTime: Long = 0

    fun start() {
        startTime = System.currentTimeMillis()
    }

    fun getTime(): Long {
        val currentTime = System.currentTimeMillis()
        return (currentTime - startTime) / 1000
    }

    fun stop() {
        startTime = 0
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ChronometerService", "Cronómetro destruido")
    }

    inner class ChronometerBinder : Binder() {
        fun getService() = this@ChronometerService
    }

}