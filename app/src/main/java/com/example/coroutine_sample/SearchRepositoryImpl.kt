package com.example.coroutine_sample

import com.example.coroutine_sample.ApiClient.retrofit

class SearchRepositoryImpl : SearchRepository {
    override suspend fun fetchArticles(tag: String, page: Int): List<Article>? {
        return retrofit.create(ApiRequest::class.java).fetchArticles(tag, page, 20).body()
    }
}
