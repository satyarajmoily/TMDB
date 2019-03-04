package com.satyaraj.app.tmdb

import com.satyaraj.app.tmdb.pojo.ListOfMovies
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCall {

    @GET("discover/movie")
    fun getAll(@Query("api_key") apiKey : String) : Single<ListOfMovies>

    @GET("movie/{id}")
    fun getDetails(@Path("id") id : String, @Query("api_key") apiKey: String): Single<Movie>
}