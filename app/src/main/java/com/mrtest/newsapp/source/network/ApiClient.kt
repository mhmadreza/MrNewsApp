package com.mrtest.newsapp.source.network

import com.mrtest.newsapp.source.news.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("top-headlines")
    suspend fun fetchPage(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") query: String,
        @Query("page") page: Int /// max page from totalSize = 20 /page
    ) : NewsModel
}