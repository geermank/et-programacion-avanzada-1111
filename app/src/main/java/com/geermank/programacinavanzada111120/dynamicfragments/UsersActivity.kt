package com.geermank.programacinavanzada111120.dynamicfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geermank.programacinavanzada111120.R

class UsersActivity : AppCompatActivity(), UsersListFragment.OnShowUserInfoListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, UsersListFragment())
            .commit()
    }

    override fun showUserInfo(name: String) {
        val fragment = UserDetailFragment.newInstance(name)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
