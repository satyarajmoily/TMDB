package com.satyaraj.app.tmdb.application

import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface ApiCall {

    @GET("/discover")
    fun getAll() : Single<List<Movie>>
}