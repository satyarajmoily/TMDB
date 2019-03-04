package com.satyaraj.app.tmdb.fragment.details

import android.util.Log
import com.satyaraj.app.tmdb.api.ApiCall
import com.satyaraj.app.tmdb.utils.Constants
import com.satyaraj.app.tmdb.base.BaseRepository
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailsRepository(compositeDisposable: CompositeDisposable, apiCall : ApiCall) : BaseRepository<DetailsPresenter>() {

    private val mCompositeDisposable = compositeDisposable
    private val mApiCall = apiCall

    fun fetchDetails(id : String){
        mCompositeDisposable.add(
            mApiCall.getDetails(id, Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Movie>() {
                    override fun onSuccess(movie: Movie) {
                        actions?.showDetails(movie)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("DetailsRepository", e.message)
                    }
                }
                ))
    }
}