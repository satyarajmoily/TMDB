package com.satyaraj.app.tmdb.fragment.details

import com.satyaraj.app.tmdb.base.BasePresenter
import com.satyaraj.app.tmdb.pojo.Movie

class DetailsPresenter(fragment: DetailsFragment, repository: DetailsRepository) : BasePresenter(), DetailsContract.Action {

    private val mView : DetailsFragment = fragment
    private val mRepository: DetailsRepository = repository

    init {
        repository.onAttach(this)
    }

    override fun getContent(id: String) {
        mRepository.fetchDetails(id)
    }

    override fun convertNumber(floatNumber: Long): String {
        val million = 1000000L
        val billion = 1000000000L
        val trillion = 1000000000000L
        val number = Math.round(floatNumber.toDouble())
        if (number in million..(billion - 1)) {
            val fraction = calculateFraction(number, million)
            return "$$fraction Million"
        } else if (number in billion..(trillion - 1)) {
            val fraction = calculateFraction(number, billion)
            return "$$fraction Billion"
        }
        return number.toString()
    }

    private fun calculateFraction(number: Long, divisor: Long): Float {
        val truncate = (number * 10L + divisor / 2L) / divisor
        return truncate.toFloat() * 0.10f
    }

    fun showDetails(movie: Movie){
        mView.displayContent(movie)
    }

}