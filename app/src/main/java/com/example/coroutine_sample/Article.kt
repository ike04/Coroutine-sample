package com.example.coroutine_sample

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("likes_count")
    val likeCount: String,
    val title: String,
    @SerializedName("updated_at")
    val updateDate: String,
    val url: String,
    val user: User
)

data class User(
    val name: String
)
