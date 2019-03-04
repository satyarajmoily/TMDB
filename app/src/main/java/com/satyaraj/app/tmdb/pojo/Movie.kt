package com.satyaraj.app.tmdb.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    @Expose
    var id: Int? = null

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

    @SerializedName("genres")
    @Expose
    var genres : List<Genre>? = null

    @SerializedName("revenue")
    @Expose
    var revenue : Long? = null

    @SerializedName("budget")
    @Expose
    var budget : Long? = null

    @SerializedName("runtime")
    @Expose
    var time : Int? = null

    @SerializedName("backdrop_path")
    @Expose
    var backdrop : String? = null

}