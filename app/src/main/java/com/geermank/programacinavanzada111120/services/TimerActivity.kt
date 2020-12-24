package com.geermank.programacinavanzada111120.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.geermank.programacinavanzada111120.R
import com.geermank.programacinavanzada111120.extensions.block
import com.geermank.programacinavanzada111120.extensions.remove
import com.geermank.programacinavanzada111120.extensions.show
import com.geermank.programacinavanzada111120.extensions.unblock
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {

    private val timerIntentFilter = IntentFilter()
    private val timerReceiver = TimerReceiver()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        timerIntentFilter.apply {
            addAction(TimerService.START)
            addAction(TimerService.END)
        }

        btn_start_timer.setOnClickListener {
            val intent = Intent(this, TimerService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }
        }

        btn_stop_timer.setOnClickListener {
            val intent = Intent(this, TimerService::class.java)
            stopService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this).registerReceiver(timerReceiver, timerIntentFilter)
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(timerReceiver)
    }

    fun showLoading() {
        progress.show()
        btn_start_timer.block()
    }

    fun hideLoading() {
        progress.remove()
        btn_start_timer.unblock()
    }

    inner class TimerReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent!!.action == TimerService.START) {
                showLoading()
            } else if (intent.action == TimerService.END) {
                hideLoading()
            }
        }
    }
}