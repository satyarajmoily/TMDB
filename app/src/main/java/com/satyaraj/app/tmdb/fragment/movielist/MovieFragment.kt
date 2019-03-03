package com.satyaraj.app.tmdb.fragment.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.satyaraj.app.tmdb.MainActivity
import com.satyaraj.app.tmdb.R
import com.satyaraj.app.tmdb.application.MoviesApplication
import com.satyaraj.app.tmdb.base.BaseFragment
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieFragment : BaseFragment<MainActivity>(), ClickListener, MovieContract.View {

    private var mMoviePresenter : MoviePresenter? = null
    private var mMovieAdapter : MovieAdapter? = null

    companion object {
        fun getNewInstance(): MovieFragment {
            return MovieFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachParent(activity as MainActivity)
        initViews(view)
        mMoviePresenter?.getMovies()
    }

    private fun initViews(view: View) {
        val mRecyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(context)
        mRecyclerView.layoutManager = layoutManager

        mMovieAdapter = MovieAdapter(this)
        mRecyclerView.adapter = mMovieAdapter

        val apiCall = MoviesApplication.get(parentActivity as MainActivity).appComponent?.apiCall
        val movieRepository = MovieRepository(CompositeDisposable(), apiCall!!)

        mMoviePresenter = MoviePresenter(this, movieRepository)
    }

    override fun displayMovies(movies: List<Movie>) {
        mMovieAdapter?.updateList(movies)
    }

    override fun onItemClicked(movie: Movie) {
    }
}