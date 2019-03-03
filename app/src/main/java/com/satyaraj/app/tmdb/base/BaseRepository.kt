package com.satyaraj.app.tmdb.base

open class BaseRepository<T : BasePresenter> {

    var actions: T? = null
        private set

    fun onAttach(actions: T) {
        this.actions = actions
    }

}