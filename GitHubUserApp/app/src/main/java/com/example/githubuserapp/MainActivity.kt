package com.example.githubuserapp;

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerview.ListUserAdapter
import com.example.myrecyclerview.User

class MainActivity : AppCompatActivity() {

    private lateinit var rvUsers: RecyclerView
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Github User's"

        rvUsers = findViewById(R.id.rv_users)
        rvUsers.setHasFixedSize(true)

        list.addAll(listUsers)
        showRecyclerList()
    }
    private val listUsers: ArrayList<User>
        get() {
            val dataUsername = resources.getStringArray(R.array.data_username)
            val dataFullName = resources.getStringArray(R.array.data_fullname)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataAvatar = resources.obtainTypedArray(R.array.data_avatar)

            val listUser = ArrayList<User>()
            for (i in dataUsername.indices) {
                val user = User(dataUsername[i],dataFullName[i], dataCompany[i],dataAvatar.getResourceId(i, -1), dataRepository[i], dataFollowers[i], dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUsers.layoutManager = GridLayoutManager(this, 2) // Landscape Grid
        } else {
            rvUsers.layoutManager = LinearLayoutManager(this) // Potrait Linear
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUsers.adapter = listUserAdapter
    }
}