package com.example.unittestformvp.ui

import com.example.unittestformvp.model.RandomUser
import com.example.unittestformvp.network.Result
import com.example.unittestformvp.repository.RandomUserRepository

class RandomUserPresenter(
    private val view: RandomUserContract.View,
    private val randomUserRepository: RandomUserRepository
) {

    fun retrieveRandomUser() {
        when (val result = randomUserRepository.getRandomUser().value) {
            is Result.Success<RandomUser> -> view.showUserProfile(result.data)
            is Result.Error -> view.onUserNotFound(result.exception.message)
            else -> {}
        }
    }

}