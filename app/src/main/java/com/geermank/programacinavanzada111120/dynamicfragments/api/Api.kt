package com.geermank.programacinavanzada111120.dynamicfragments.api

import com.geermank.programacinavanzada111120.dynamicfragments.models.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("users")
    fun getUsers(): Call<List<User>>

}