package com.satyaraj.app.tmdb.fragment.movielist

import com.satyaraj.app.tmdb.base.BasePresenter
import com.satyaraj.app.tmdb.pojo.Movie

class MoviePresenter(fragment: MovieFragment, repository: MovieRepository) : BasePresenter(),
    MovieContract.Action {

    private val mView : MovieFragment = fragment
    private val mRepository: MovieRepository = repository

    init {
        mRepository.onAttach(this)
    }

    override
    fun getMovies() {
        mRepository.getMovieList()
    }

    fun fetchedMovies(movies: List<Movie>) {
        mView.displayMovies(movies)
    }
}