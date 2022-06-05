package com.example.coroutine_sample

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRequest {
    @GET("tags/{tag_id}/items")
    suspend fun fetchArticles(
        @Path("tag_id") tagId: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<List<Article>>
}
