package com.example.maria.homework_10.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.maria.homework_10.*
import com.example.maria.homework_10.adapter.RecyclerViewAdapter
import com.example.maria.homework_10.decoration.SampleDecoration
import com.example.maria.homework_10.presenters.MainPresenter
import com.example.maria.homework_10.presenters.MainView
import com.example.maria.homework_10.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {


    private val presenter by lazy {
        MainPresenter(Repository(),this)
    }
    lateinit var students: Array<Pair<String, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.fetchUsersList()

        var adapter = RecyclerViewAdapter(students, this)
        rv_students_list.layoutManager = LinearLayoutManager(this)
        rv_students_list.adapter = adapter
        rv_students_list.addItemDecoration(
                SampleDecoration(
                        this
                )
        )

        adapter.setOnItemClickListener(object : RecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, UserProfileActivity::class.java)
                intent.putExtra("UserLogin", students[position].second)
                startActivity(intent)
            }
        })
    }

    override fun showUsersList(studentsList: Array<Pair<String, String>>) {
        students = studentsList
    }
}
