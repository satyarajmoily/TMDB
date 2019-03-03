package com.satyaraj.app.tmdb.fragment.movielist

import com.satyaraj.app.tmdb.pojo.Movie

interface ClickListener {

    fun onItemClicked(movie: Movie)
}