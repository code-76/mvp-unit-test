package com.example.unittestformvp

import com.example.unittestformvp.extensions.removeAll
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ExtensionsTest {

    private val wrongText = "I'm mac mac mac come from UK."
    private val expectText = "I'm come from UK."

    @Test
    fun testRemoveAll(){
        Assert.assertEquals(expectText, wrongText.removeAll("mac "))
    }

}