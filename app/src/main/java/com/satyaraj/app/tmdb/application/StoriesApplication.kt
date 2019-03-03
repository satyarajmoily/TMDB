package com.satyaraj.app.tmdb.application

import android.app.Activity
import android.app.Application
import com.satyaraj.app.tmdb.application.di.AppComponent

class StoriesApplication : Application() {
    var apiCall: ApiCall? = null
        private set
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        initializeComponents()
    }

    private fun initializeComponents() {

        //TODO
//        appComponent = DaggerAppComponent
//            .builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//        appDatabase = appComponent!!.getAppDatabase()
//        apiCall = appComponent!!.getApiCall()
    }

    companion object {

        //TODO
//        var appDatabase: AppDatabase? = null
//            private set

        operator fun get(activity: Activity): StoriesApplication {
            return activity.application as StoriesApplication
        }
    }
}