package com.example.maria.homework_10.presenters

import com.example.maria.homework_10.repository.Repository

class MainPresenter(private val repository: Repository,
                    val view: MainView ) {

    fun fetchUsersList(){
        val students = repository.getStudentsData()
        view.showUsersList(students)
    }
}