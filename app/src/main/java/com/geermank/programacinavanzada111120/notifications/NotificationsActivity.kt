package com.geermank.programacinavanzada111120.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.geermank.programacinavanzada111120.R
import com.geermank.programacinavanzada111120.dynamicfragments.UsersActivity
import com.geermank.programacinavanzada111120.threads.BlockingTaskActivity
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        btn_show_notification.setOnClickListener {
            showNotification()
        }
    }

    private fun showNotification() {
        val blockingTaskIntent = Intent(this, BlockingTaskActivity::class.java)

        val taskStackBuilder = TaskStackBuilder.create(this)
        taskStackBuilder.addNextIntentWithParentStack(blockingTaskIntent)
        val tapPendingIntent = taskStackBuilder.getPendingIntent(11, PendingIntent.FLAG_UPDATE_CURRENT)

        val actionIntent = Intent(this, UsersActivity::class.java)
        val actionPendingIntent = PendingIntent.getActivity(this, 11, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, "ofertas-id")
            .setContentTitle("Black friday!!")
            .setContentText("30% de descuento en electrodomésticos")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(tapPendingIntent)
            .addAction(0, "Ver usuarios", actionPendingIntent)
            .setAutoCancel(false)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("ofertas-id", "Ofertas", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(1, builder.build())
    }
}