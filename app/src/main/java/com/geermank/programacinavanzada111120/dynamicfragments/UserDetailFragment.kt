package com.geermank.programacinavanzada111120.dynamicfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geermank.programacinavanzada111120.R
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment() {

    companion object {
        private const val USER_NAME_EXTRA = "USER_NAME"

        /*
        fun newInstance(userName: String): Fragment {
            val newUserDetailFragment = UserDetailFragment()

            val args = Bundle()
            args.putString(USER_NAME_EXTRA, userName)

            newUserDetailFragment.arguments = args

            return newUserDetailFragment
        }
        */

        fun newInstance(userName: String) = UserDetailFragment().apply {
            arguments = Bundle().also { it.putString(USER_NAME_EXTRA, userName) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userName = requireArguments().getString(USER_NAME_EXTRA)
        tv_user_name.text = userName
    }
}