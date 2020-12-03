package com.geermank.programacinavanzada111120.threads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.activity_blocking_task.*

class BlockingTaskActivity : AppCompatActivity(), LoadingCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blocking_task)
        BackgroundTask(this).execute(10)
    }

    override fun startLoading() {
        Toast.makeText(this, "Comenzando la tarea", Toast.LENGTH_SHORT).show()
    }

    override fun finishLoading() {
        Toast.makeText(this, "Finalizó la tarea", Toast.LENGTH_SHORT).show()
        pb.visibility = View.GONE
    }
}