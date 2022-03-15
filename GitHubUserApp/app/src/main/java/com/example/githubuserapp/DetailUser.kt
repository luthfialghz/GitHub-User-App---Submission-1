package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myrecyclerview.User

class DetailUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        supportActionBar?.title = "Detail User"

        val user = intent.getParcelableExtra<User>(EXTRA_PERSON) as User

        val tvUsername : TextView = findViewById(R.id.tv_item_username)
        val tvFullName : TextView = findViewById(R.id.tv_item_fullname)
        val tvCompany : TextView = findViewById(R.id.tv_item_company)
        val tvRepository : TextView = findViewById(R.id.tv_item_repository)
        val tvFollowers : TextView = findViewById(R.id.tv_item_followers)
        val tvFollowing : TextView = findViewById(R.id.tv_item_following)
        val imgPhoto : ImageView = findViewById(R.id.img_item_avatar)

        tvUsername.text = user.username
        tvFullName.text = user.fullname
        tvCompany.text = user.company
        tvRepository.text = user.repository
        tvFollowers.text = user.followers
        tvFollowing.text = user.following

        Glide.with(this)
            .load(user.photo)
            .apply(RequestOptions())
            .into(imgPhoto)
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
}