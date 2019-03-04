package com.satyaraj.app.tmdb.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Genre {

    @SerializedName("name")
    @Expose
    var name : String ? = null
}