package com.satyaraj.app.tmdb.fragment.movielist

import android.util.Log
import com.satyaraj.app.tmdb.api.ApiCall
import com.satyaraj.app.tmdb.base.BaseRepository
import com.satyaraj.app.tmdb.MethodUtils.Constants
import com.satyaraj.app.tmdb.pojo.ListOfMovies
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MovieRepository(compositeDisposable : CompositeDisposable,
                      apiCall : ApiCall) : BaseRepository<MoviePresenter>() {

    private val mCompositeDisposable = compositeDisposable
    private val mApiCall = apiCall

    fun getMovieList(){
        mCompositeDisposable.add(
            mApiCall.getAll(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ListOfMovies>() {
                    override fun onSuccess(listOfMovies: ListOfMovies) {
                         actions?.fetchedMovies(listOfMovies.movies!!)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("MovieRepository", e.message)
                    }
                }
                ))
    }
}