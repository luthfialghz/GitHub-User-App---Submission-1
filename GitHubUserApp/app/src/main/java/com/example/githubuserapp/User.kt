package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username: String,
    var fullname: String,
    var company: String,
    var photo: Int,
    var repository: String,
    var followers: String,
    var following: String
) : Parcelable
