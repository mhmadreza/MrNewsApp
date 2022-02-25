package com.mrtest.newsapp.ui.bookmark

import androidx.lifecycle.ViewModel
import com.mrtest.newsapp.source.news.NewsRepository
import org.koin.dsl.module

val bookmarkViewModel = module {
    factory { BookmarkViewModel(get()) }
}

class BookmarkViewModel(
    repository: NewsRepository
) : ViewModel() {

    val title = "Bookmark"
    val articles = repository.db.findAll()

}