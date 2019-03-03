package com.satyaraj.app.tmdb.fragment.movielist

import android.util.Log
import com.satyaraj.app.tmdb.application.ApiCall
import com.satyaraj.app.tmdb.base.BaseRepository
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MovieRepository(compositeDisposable : CompositeDisposable,
                      apiCall : ApiCall) : BaseRepository<MoviePresenter>() {

    private val mCompositeDisposable: CompositeDisposable = compositeDisposable
    private val mApiCall: ApiCall = apiCall

    fun getMovieList(){
        mCompositeDisposable.add(
            mApiCall.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Movie>>() {
                    override fun onSuccess(movies: List<Movie>) {
                         actions?.fetchedMovies(movies)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("MovieRepository", e.message)
                    }
                }
                ))
    }

}