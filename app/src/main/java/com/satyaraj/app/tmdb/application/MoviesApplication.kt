package com.satyaraj.app.tmdb.application

import android.app.Activity
import android.app.Application
import com.satyaraj.app.tmdb.ApiCall
import com.satyaraj.app.tmdb.application.di.AppComponent
import com.satyaraj.app.tmdb.application.di.ApplicationModule
import com.satyaraj.app.tmdb.application.di.DaggerAppComponent

class MoviesApplication : Application() {
    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeComponents()
    }

    private fun initializeComponents() {
        appComponent = DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        operator fun get(activity: Activity): MoviesApplication {
            return activity.application as MoviesApplication
        }
    }
}