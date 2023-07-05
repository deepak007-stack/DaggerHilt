package com.example.jetpackseries.daggerhiltcourse.data.repository

import android.app.Application
import com.example.jetpackseries.R
import com.example.jetpackseries.daggerhiltcourse.data.remote.MyApi
import com.example.jetpackseries.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override suspend fun doNetworkCall() {

    }
}