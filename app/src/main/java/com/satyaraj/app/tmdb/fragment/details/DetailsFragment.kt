package com.satyaraj.app.tmdb.fragment.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.satyaraj.app.tmdb.MainActivity
import com.satyaraj.app.tmdb.R
import com.satyaraj.app.tmdb.application.MoviesApplication
import com.satyaraj.app.tmdb.base.BaseFragment
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.disposables.CompositeDisposable


class DetailsFragment : BaseFragment<MainActivity>(), DetailsContract.View{

    private var poster : ImageView? = null
    private var description : TextView? = null
    private var duration : TextView? = null
    private var date : TextView? = null
    private var rating : TextView? = null
    private var genre : TextView? = null
    private var language : TextView? = null
    private var budget : TextView? = null
    private var revenue : TextView? = null
    private var detailsPresenter : DetailsPresenter? = null
    private var layout : ConstraintLayout? = null

    companion object {

        const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

        const val MOVIE_ID = "100"

        fun getNewInstance(id : String): DetailsFragment {
            val detailsFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString(MOVIE_ID, id)
            detailsFragment.arguments = bundle
            return detailsFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachParent(activity as MainActivity)
        initViews(view)
        val id = arguments?.get(MOVIE_ID)
        detailsPresenter?.getContent(id.toString())
    }

    private fun initViews(view: View) {
        poster = view.findViewById(R.id.movie_poster)
        description = view.findViewById(R.id.movie_desc)
        duration = view.findViewById(R.id.duration)
        date = view.findViewById(R.id.movie_date)
        rating = view.findViewById(R.id.movie_rating)
        genre = view.findViewById(R.id.genre)
        language = view.findViewById(R.id.movie_lang)
        budget = view.findViewById(R.id.budget)
        revenue = view.findViewById(R.id.revenue)
        layout = view.findViewById(R.id.layout)

        layout?.visibility = View.GONE

        val apiCall = MoviesApplication[parentActivity as MainActivity].appComponent?.apiCall
        val detailsRepository = DetailsRepository(CompositeDisposable(), apiCall!!)
        detailsPresenter = DetailsPresenter(this, detailsRepository)
    }

    override fun displayContent(movie: Movie) {
        description?.text = movie.movieDesc
        val durationText = movie.time.toString() + " minutes"
        duration?.text = durationText
        date?.text = movie.movieDate
        rating?.text = movie.movieRating

        var genreText = ""

        for (genreItem in movie.genres!!) genreText =  genreItem.name + ", " + genreText

        genre?.text = genreText.substring(0, genreText.length - 2)
        language?.text = movie.movieLang

        budget?.text = detailsPresenter?.convertNumber(movie.budget!!)
        revenue?.text = detailsPresenter?.convertNumber(movie.revenue!!)

        val imageUrl = IMAGE_BASE_URL + movie.backdrop

        Glide.with(context!!)
            .load(imageUrl)
            .into(poster!!)

        layout?.visibility = View.VISIBLE
    }
}