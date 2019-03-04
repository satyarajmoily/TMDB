package com.satyaraj.app.tmdb.fragment.details

import com.satyaraj.app.tmdb.pojo.Movie

interface DetailsContract {

    interface View{
        fun displayContent(movie : Movie)
    }

    interface Action{
        fun getContent(id: String)

        fun convertNumber(floatNumber: Long) : String
    }
}