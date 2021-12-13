package com.example.unittestformvp.ui

import com.example.unittestformvp.model.RandomUser

class RandomUserContract {
    interface View {
        fun showUserProfile(randomUser: RandomUser?)
        fun onUserNotFound(error: String?)
    }
}