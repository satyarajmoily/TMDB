package com.satyaraj.app.tmdb.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListOfMovies {

    @SerializedName("results")
    @Expose
    var movies : List<Movie>? = null
}