package com.geermank.programacinavanzada111120

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geermank.programacinavanzada111120.dynamicfragments.UsersActivity
import com.geermank.programacinavanzada111120.notifications.NotificationsActivity
import com.geermank.programacinavanzada111120.permissions.LocationActivity
import com.geermank.programacinavanzada111120.services.ChronometerActivity
import com.geermank.programacinavanzada111120.services.TimerActivity
import com.geermank.programacinavanzada111120.staticfragments.StaticFragmentsActivity
import com.geermank.programacinavanzada111120.threads.BlockingTaskActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_static_fragments.setOnClickListener {
            startActivity(Intent(this, StaticFragmentsActivity::class.java))
        }

        btn_dynamic_fragments.setOnClickListener {
            startActivity(Intent(this, UsersActivity::class.java))
        }

        btn_background_task.setOnClickListener {
            startActivity(Intent(this, BlockingTaskActivity::class.java))
        }

        btn_notifications.setOnClickListener {
            startActivity(Intent(this, NotificationsActivity::class.java))
        }

        btn_location.setOnClickListener {
            startActivity(Intent(this, LocationActivity::class.java))
        }

        btn_timer.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        btn_chronometer.setOnClickListener {
            startActivity(Intent(this, ChronometerActivity::class.java))
        }
    }
}
