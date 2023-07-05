package com.example.jetpackseries.retro.util

import com.example.jetpackseries.retro.Post

sealed class ApiState {
    class Success(val data: List<Post>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()
}