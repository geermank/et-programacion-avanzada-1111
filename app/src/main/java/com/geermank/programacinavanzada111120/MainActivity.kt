package com.geermank.programacinavanzada111120

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geermank.programacinavanzada111120.dynamicfragments.UsersActivity
import com.geermank.programacinavanzada111120.staticfragments.StaticFragmentsActivity
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
    }
}
