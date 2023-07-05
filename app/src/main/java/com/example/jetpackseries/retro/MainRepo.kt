package com.example.jetpackseries.retro

import com.example.jetpackseries.retro.network.ApiServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepo
@Inject
constructor(private val apiService: ApiServices) {

    fun getPost(): Flow<List<Post>> = flow {
        emit(apiService.getPost())
    }.flowOn(Dispatchers.IO)

}