package com.example.unittestformvp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unittestformvp.model.RandomUser
import com.example.unittestformvp.network.NetworkUnit
import com.example.unittestformvp.network.RandomUserApi
import com.example.unittestformvp.network.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RandomUserRepository {

    fun getRandomUser(): LiveData<Result<RandomUser>> {
        val randomUser = MutableLiveData<Result<RandomUser>>()
        NetworkUnit.connect<RandomUserApi>().getRandomUser().enqueue(object : Callback<RandomUser> {
            override fun onResponse(call: Call<RandomUser>, response: Response<RandomUser>) {
                response.body()?.also {
                    randomUser.value = Result.Success(it)
                } ?: run {
                    Result.Error(Exception("Empty Data!"))
                }
            }

            override fun onFailure(call: Call<RandomUser>, t: Throwable) {
                randomUser.value = Result.Error(Exception(t.message))
            }
        })

        return randomUser
    }

}