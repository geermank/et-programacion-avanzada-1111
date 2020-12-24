package com.geermank.programacinavanzada111120.alarms

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import com.geermank.programacinavanzada111120.R
import com.geermank.programacinavanzada111120.broadcasts.BatteryLowActivity
import com.geermank.programacinavanzada111120.dynamicfragments.UsersActivity
import com.geermank.programacinavanzada111120.extensions.toast
import com.geermank.programacinavanzada111120.services.TimerService
import kotlinx.android.synthetic.main.activity_alarms.*
import java.util.*

class AlarmsActivity : AppCompatActivity() {

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarms)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        btn_elapsed_realtime.setOnClickListener {
            val alarmType = AlarmManager.ELAPSED_REALTIME_WAKEUP

            val intent = Intent(this, TimerService::class.java)
            val pendingIntent = PendingIntent.getForegroundService(this, 11, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val triggerTime = SystemClock.elapsedRealtime() + (1000 * 30)

            alarmManager.setExact(alarmType, triggerTime, pendingIntent)

            toast("Alarma agendada")
        }

        btn_rtc.setOnClickListener {
            val alarmType = AlarmManager.RTC_WAKEUP

            val intent = Intent(this, BatteryLowActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 11, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.HOUR_OF_DAY, 22)
                set(Calendar.MINUTE, 30)
            }

            alarmManager.setInexactRepeating(alarmType, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
        }
    }
}
