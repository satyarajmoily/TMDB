package com.satyaraj.app.tmdb.fragment.movielist

import com.satyaraj.app.tmdb.pojo.Movie

interface MovieContract {

    interface View {
        fun displayMovies(stories: List<Movie>)
    }

    interface Action {
        fun getMovies()
    }
}