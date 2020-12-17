package com.geermank.programacinavanzada111120.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.activity_chronometer.*

class ChronometerActivity : AppCompatActivity() {

    private lateinit var chronometerService: ChronometerService
    private var connected: Boolean = false

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            connected = true
            val chronometerBinder = service as ChronometerService.ChronometerBinder
            chronometerService = chronometerBinder.getService()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            connected = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)

        btn_start_chronometer.setOnClickListener {
            if (connected) {
                chronometerService.start()
            }
        }

        btn_get_elapsed_time.setOnClickListener {
            if (connected) {
                val time = chronometerService.getTime()
                Toast.makeText(this, "Pasaron $time segundos", Toast.LENGTH_SHORT).show()
            }
        }

        btn_stop_chronometer.setOnClickListener {
            if (connected) {
                chronometerService.stop()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, ChronometerService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(serviceConnection)
    }
}
