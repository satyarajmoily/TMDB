package com.satyaraj.app.tmdb.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("title")
    @Expose
    var movieTitle: String? = null

    @SerializedName("poster_path")
    @Expose
    var url : String? = null

    @SerializedName("overview")
    @Expose
    var movieDesc : String? = null

    @SerializedName("vote_average")
    @Expose
    var movieRating : String? = null

    @SerializedName("release_date")
    @Expose
    var movieDate : String? = null

    @SerializedName("original_language")
    @Expose
    var movieLang : String? = null
}