package com.mrtest.newsapp.source.persistance

import android.app.Application
import androidx.room.Room
import com.mrtest.newsapp.source.news.NewsDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideDatabase(androidApplication()) }
    single { provideArticle(get()) }

}

fun provideDatabase(application: Application): DatabaseClient {
    return Room.databaseBuilder(application, DatabaseClient::class.java, "mrtestNews.db")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideArticle(database: DatabaseClient): NewsDAO {
    return  database.newsDao
}