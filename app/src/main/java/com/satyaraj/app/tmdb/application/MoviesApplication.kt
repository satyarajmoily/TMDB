package com.satyaraj.app.tmdb.application

import android.app.Activity
import android.app.Application
import com.satyaraj.app.tmdb.application.di.AppComponent
import com.satyaraj.app.tmdb.application.di.ApplicationModule
import com.satyaraj.app.tmdb.application.di.DaggerAppComponent

@Suppress("DEPRECATION")
class MoviesApplication : Application() {
    var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeComponents()
    }

    private fun initializeComponents() {
        //applicationModule is deprecated since no object is been injected yet
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