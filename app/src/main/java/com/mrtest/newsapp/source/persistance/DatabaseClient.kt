package com.mrtest.newsapp.source.persistance

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mrtest.newsapp.source.news.ArticleModel
import com.mrtest.newsapp.source.news.NewsDAO
import com.mrtest.newsapp.utils.NetworkConverter

@Database(
    entities = [ArticleModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(NetworkConverter::class)
abstract class DatabaseClient : RoomDatabase() {
    abstract val newsDao: NewsDAO
}