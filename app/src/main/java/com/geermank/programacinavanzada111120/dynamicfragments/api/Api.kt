package com.geermank.programacinavanzada111120.dynamicfragments.api

import com.geermank.programacinavanzada111120.dynamicfragments.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users")
    fun getUsersByIdUsingQuery(@Query("id") userId: Int): Call<List<User>>

    @GET("users/{id}")
    fun getUsersById(@Path("id") userId: Int): Call<List<User>>
}