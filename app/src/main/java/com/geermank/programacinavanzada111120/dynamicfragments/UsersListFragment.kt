package com.geermank.programacinavanzada111120.dynamicfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.fragment_users_list.*

class UsersListFragment : Fragment() {

    interface OnShowUserInfoListener {
        fun showUserInfo(name: String)
    }

    private lateinit var listener: OnShowUserInfoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnShowUserInfoListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_show_user_info.setOnClickListener {
            listener.showUserInfo("Mirta")
        }
    }
}