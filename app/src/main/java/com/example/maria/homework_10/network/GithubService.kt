package com.example.maria.homework_10.network

import com.example.maria.homework_10.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users/{user}")
    fun getCurrentWeather(
            @Path("user") user: String,
            @Query("client_id") client_id: String = "xxxx",
            @Query("client_secret") mode: String = "yyyy"
    ): Call<UserResponse>
}