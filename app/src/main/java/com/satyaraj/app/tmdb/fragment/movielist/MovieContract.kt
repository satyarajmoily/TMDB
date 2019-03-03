package com.satyaraj.app.tmdb.fragment.movielist

import com.satyaraj.app.tmdb.pojo.Movie

interface MovieContract {

    interface View {
        fun displayMovies(movies: List<Movie>)
    }

    interface Action {
        fun getMovies()
    }
}