package com.satyaraj.app.tmdb.application.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.satyaraj.app.tmdb.BuildConfig
import com.satyaraj.app.tmdb.ApiCall
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    @AppScope
    fun getApiCall(apiCallRetrofit: Retrofit): ApiCall {
        return apiCallRetrofit.create(ApiCall::class.java)
    }

    @Provides
    @AppScope
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @AppScope
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @AppScope
    fun okHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .build()
    }

}