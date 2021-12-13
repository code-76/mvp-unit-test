package com.example.unittestformvp.network

import com.example.unittestformvp.model.RandomUser
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserApi {
    @GET("/")
    fun getRandomUser(): Call<RandomUser>
}