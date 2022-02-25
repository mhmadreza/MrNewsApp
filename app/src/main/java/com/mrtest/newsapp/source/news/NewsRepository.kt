package com.mrtest.newsapp.source.news

import com.mrtest.newsapp.BuildConfig
import com.mrtest.newsapp.source.network.ApiClient
import org.koin.dsl.module

val repositoryModule = module {
    factory { NewsRepository(get(), get()) }
}

class NewsRepository(
    private val api: ApiClient,
    val db: NewsDAO,
) {

    suspend fun page(
        category: String? = "",
        query: String,
        page: Int
    ): NewsModel {
        return api.fetchPage( BuildConfig.API_KEY, "id", category!!, query, page)
    }

    suspend fun find(articleModel: ArticleModel) = db.find(articleModel.publishedAt)

    suspend fun save(articleModel: ArticleModel) {
        db.save( articleModel )
    }

    suspend fun remove(articleModel: ArticleModel) {
        db.remove( articleModel )
    }

}