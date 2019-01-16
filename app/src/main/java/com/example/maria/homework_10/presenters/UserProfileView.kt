package com.example.maria.homework_10.presenters

import com.example.maria.homework_10.model.UserResponse

interface UserProfileView {
    fun showUser(user: UserResponse)

    fun loadFailed()
}