package com.example.unittestformvp

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.example.unittestformvp.ui.TestAppApplication

class UnitTestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestAppApplication::class.java.simpleName, context)
    }

    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
    }

    override fun finish(resultCode: Int, results: Bundle?) {
        super.finish(resultCode, results)
    }

}