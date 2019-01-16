package com.example.maria.homework_10.presenters

import android.net.ConnectivityManager
import com.example.maria.homework_10.model.UserResponse
import com.example.maria.homework_10.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserProfilePresenter(
        private val repository: Repository,
        val view: UserProfileView
) {

    fun fetchUserProfile(city: String, connMgr: ConnectivityManager) {
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            repository.getProfileData(city).enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                        call: Call<UserResponse>,
                        response: Response<UserResponse>
                ) {
                    if (response.body() != null)
                        view.showUser(response.body()!!)
                    else
                        view.loadFailed("Load failed, please try again later!")
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                }
            })
        }
        else
            view.loadFailed("No Internet connection!")
    }
}