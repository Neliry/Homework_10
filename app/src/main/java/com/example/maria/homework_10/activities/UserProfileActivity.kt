package com.example.maria.homework_10.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.maria.homework_10.R
import com.example.maria.homework_10.model.UserResponse
import com.example.maria.homework_10.presenters.UserProfilePresenter
import com.example.maria.homework_10.presenters.UserProfileView
import com.example.maria.homework_10.repository.Repository
import kotlinx.android.synthetic.main.activity_user_profile.*
import android.net.ConnectivityManager
import android.view.View
import com.bumptech.glide.Glide


class UserProfileActivity : AppCompatActivity(), UserProfileView {

    private val presenter by lazy {
        UserProfilePresenter(Repository(), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        var userLogin: String = intent.getStringExtra("UserLogin")
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        presenter.fetchUserProfile(userLogin, connMgr)
    }

    override fun showUser(user: UserResponse) {
        login_view.text = user.login
        name_view.text = user.name
        url_view.text= user.html_url
        followers_view.text = user.followers.toString()
        following_view.text = user.following.toString()
        Glide.with(this).load(user.avatar_url).into(profile_image)
        repositories_view.text = user.public_repos.toString()
        gists_view.text = user.public_gists.toString()
        loading_indicator.visibility = View.GONE
        user_info_view.visibility = View.VISIBLE
    }
    override fun loadFailed(message: String) {
        loading_indicator.visibility = View.GONE
        load_failed_view.text = message
        load_failed_view.visibility = View.VISIBLE
    }
}
