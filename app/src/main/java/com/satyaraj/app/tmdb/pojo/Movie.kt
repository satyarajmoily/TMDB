package com.satyaraj.app.tmdb.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("")
    @Expose
    var movieTitle: String? = null

    @SerializedName("")
    @Expose
    var url : String? = null

    @SerializedName("")
    @Expose
    var movieDesc : String? = null

    @SerializedName("")
    @Expose
    var movieRating : String? = null

    @SerializedName("")
    @Expose
    var movieDate : String? = null

    @SerializedName("")
    @Expose
    var movieLang : String? = null
}