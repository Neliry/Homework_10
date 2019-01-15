package com.example.maria.homework_10.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.maria.homework_10.R
import com.example.maria.homework_10.model.UserResponse
import com.example.maria.homework_10.presenters.UserProfilePresenter
import com.example.maria.homework_10.presenters.UserProfileView
import com.example.maria.homework_10.repository.Repository
import kotlinx.android.synthetic.main.activity_user_profile.*
import android.graphics.drawable.Drawable
import android.text.method.LinkMovementMethod
import android.view.View
import com.bumptech.glide.Glide
import java.io.InputStream
import java.net.URL


class UserProfileActivity : AppCompatActivity(), UserProfileView {

    private val presenter by lazy {
        UserProfilePresenter(Repository(), this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        var userLogin: String = intent.getStringExtra("UserLogin")

        presenter.fetchUserProfile(userLogin)
    }

    override fun showUser(user: UserResponse) {
        login_view.text = user.login

        if(user.name != null)
            name_view.text = user.name

        url_view.text= user.html_url

        followers_view.text = user.followers.toString()

        following_view.text = user.following.toString()

        if(user.avatar_url != null)
            Glide.with(this).load(user.avatar_url).into(profile_image)

        repositories_view.text = user.public_repos.toString()

        gists_view.text = user.public_gists.toString()

        loading_indicator.visibility = View.GONE

        user_info_view.visibility = View.VISIBLE
    }
}
