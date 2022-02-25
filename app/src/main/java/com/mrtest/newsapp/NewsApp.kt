package com.mrtest.newsapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.mrtest.newsapp.source.network.networkModule
import com.mrtest.newsapp.source.news.repositoryModule
import com.mrtest.newsapp.source.persistance.databaseModule
import com.mrtest.newsapp.ui.bookmark.bookmarkModule
import com.mrtest.newsapp.ui.bookmark.bookmarkViewModel
import com.mrtest.newsapp.ui.detail.detailModule
import com.mrtest.newsapp.ui.detail.detailViewModel
import com.mrtest.newsapp.ui.home.homeModule
import com.mrtest.newsapp.ui.home.homeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Untuk Debug Log
        Timber.plant(Timber.DebugTree())
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // Depedency Injection Koin
        startKoin {
            androidLogger()
            androidContext(this@NewsApp)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                homeModule,
                homeViewModel,
                bookmarkModule,
                bookmarkViewModel,
                detailModule,
                detailViewModel
            )
        }

    }

}