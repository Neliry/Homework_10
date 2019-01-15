package com.example.maria.homework_10.repository

import com.example.maria.homework_10.model.UserResponse
import com.example.maria.homework_10.network.GithubService
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val openWeatherService = retrofit.create(GithubService::class.java)

    fun getData(city: String): Call<UserResponse> {
        return openWeatherService.getCurrentWeather(city)
    }
}