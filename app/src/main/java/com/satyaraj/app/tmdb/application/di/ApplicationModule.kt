package com.satyaraj.app.tmdb.application.di

import android.content.Context
import com.satyaraj.app.tmdb.application.MoviesApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(@get:Provides val application: MoviesApplication) {

    private val context: Context = application.applicationContext

    @Provides
    @ApplicationContext
    fun context(): Context {
        return context
    }
}