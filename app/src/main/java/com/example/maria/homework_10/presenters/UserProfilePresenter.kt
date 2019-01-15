package com.example.maria.homework_10.presenters

import com.example.maria.homework_10.model.UserResponse
import com.example.maria.homework_10.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserProfilePresenter(
        private val repository: Repository,
        val view: UserProfileView
) {

    fun fetchUserProfile(city: String) {
        repository.getData(city).enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
            ) {
                if(response.body()!=null)
                    view.showUser(response.body()!!)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })
    }
}