package com.example.unittestformvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unittestformvp.R
import com.example.unittestformvp.model.RandomUser
import com.example.unittestformvp.repository.RandomUserRepository

class MainActivity : AppCompatActivity(), RandomUserContract.View {

    private lateinit var randomUserPresenter: RandomUserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = RandomUserRepository()
        randomUserPresenter = RandomUserPresenter(this, repository)
        randomUserPresenter.retrieveRandomUser()
    }

    override fun showUserProfile(randomUser: RandomUser?) {
        TODO("Not yet implemented")
    }

    override fun onUserNotFound(error: String?) {
        TODO("Not yet implemented")
    }


}