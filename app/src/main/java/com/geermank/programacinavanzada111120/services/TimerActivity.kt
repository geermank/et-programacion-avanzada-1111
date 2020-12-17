package com.geermank.programacinavanzada111120.services

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

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
}