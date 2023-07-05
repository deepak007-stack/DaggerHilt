package com.example.jetpackseries.retro.network

import com.example.jetpackseries.retro.Post
import retrofit2.http.GET

interface ApiServices {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<Post>
}