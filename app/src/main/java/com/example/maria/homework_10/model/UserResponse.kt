package com.example.maria.homework_10.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
        @SerializedName("login") val login: String,
        @SerializedName("name") val name: String,
        @SerializedName("html_url") val html_url: String,
        @SerializedName("public_repos") val public_repos: Int,
        @SerializedName("public_gists") val public_gists: Int,
        @SerializedName("followers") val followers: Int,
        @SerializedName("following") val following: Int,
        @SerializedName("avatar_url") val avatar_url: String
)