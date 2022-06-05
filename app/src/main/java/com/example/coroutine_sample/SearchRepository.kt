package com.example.coroutine_sample

interface SearchRepository {
    suspend fun fetchArticles(tag: String, page: Int): List<Article>?
}
