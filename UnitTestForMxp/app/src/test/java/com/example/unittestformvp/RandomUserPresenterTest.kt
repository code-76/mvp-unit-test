package com.example.unittestformvp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.unittestformvp.model.RandomUser
import com.example.unittestformvp.repository.RandomUserRepository
import com.example.unittestformvp.ui.RandomUserContract
import com.example.unittestformvp.ui.RandomUserPresenter
import com.example.unittestformvp.network.Result
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
class RandomUserPresenterTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var view: RandomUserContract.View

    private lateinit var randomUserRepository: RandomUserRepository

    private lateinit var randomUserPresenter: RandomUserPresenter

    private val randomUser = RandomUser(info = null, results = null)

    private val successResult: LiveData<Result<RandomUser>> = MutableLiveData(Result.Success(randomUser))

    private val failResult: LiveData<Result<RandomUser>> = MutableLiveData(Result.Error(Exception("Empty Data!")))

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        MockKAnnotations.init(this)

        randomUserRepository = mockk(relaxed = true)
        randomUserPresenter = RandomUserPresenter(view, randomUserRepository)
    }

    @Test
    fun testRandomUserSuccess() {

        // when
        every { randomUserRepository.getRandomUser() } returns successResult

        // then
        randomUserPresenter.retrieveRandomUser()

        // given
        verify {
            view.showUserProfile(randomUser)
        }
    }

    @Test
    fun testRandomUserFail() {

        // when
        every { randomUserRepository.getRandomUser() } returns failResult

        // then
        randomUserPresenter.retrieveRandomUser()

        // given
        verify {
            view.onUserNotFound("Empty Data!")
        }
    }

    @After
    fun tearDown() {

    }
}