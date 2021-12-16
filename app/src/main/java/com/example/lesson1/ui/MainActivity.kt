package com.example.lesson1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson1.R
import com.example.lesson1.adapters.UsersListAdapter
import com.example.lesson1.fillFakeData

class MainActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillFakeData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.usersRecyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = UsersListAdapter()
        }
    }

    // read about git
    // open github account
    // add project to git
    // share with shush.meliqsetyan@gmail.com

}