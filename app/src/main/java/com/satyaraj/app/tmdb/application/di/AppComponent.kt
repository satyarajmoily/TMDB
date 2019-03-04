package com.satyaraj.app.tmdb.application.di

import com.satyaraj.app.tmdb.api.ApiCall
import dagger.Component

@AppScope
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface AppComponent {

    val apiCall: ApiCall

}