package com.geermank.programacinavanzada111120.dynamicfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.geermank.programacinavanzada111120.R
import com.geermank.programacinavanzada111120.dynamicfragments.api.Api
import com.geermank.programacinavanzada111120.dynamicfragments.models.User
import com.geermank.programacinavanzada111120.extensions.remove
import kotlinx.android.synthetic.main.fragment_users_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val api: Api = retrofit.create(Api::class.java)
        api.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                hideProgressBar()
                if (response.isSuccessful) {
                    val users = response.body()
                    handleUsersResponse(users)
                } else {
                    Toast.makeText(context, "Ocurrió un error con esta petición", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                hideProgressBar()
                Toast.makeText(context, "Ocurrió un error inesperado", Toast.LENGTH_SHORT).show()
            }
        })

        btn_show_user_info.setOnClickListener {
            listener.showUserInfo("Mirta")
        }
    }

    private fun handleUsersResponse(users: List<User>?) {
        Toast.makeText(context, "Obtuvimos ${users?.size} usuarios", Toast.LENGTH_SHORT).show()
    }

    private fun hideProgressBar() {
        user_progress.remove()
    }
}