package com.example.unittestformvp.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkUnit {

    inline fun <reified T> connect(apiUrl: String = "https://randomuser.me/api/"): T {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build().create(T::class.java)
    }

}