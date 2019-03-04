package com.satyaraj.app.tmdb.fragment.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.satyaraj.app.tmdb.MainActivity
import com.satyaraj.app.tmdb.R
import com.satyaraj.app.tmdb.application.MoviesApplication
import com.satyaraj.app.tmdb.base.BaseFragment
import com.satyaraj.app.tmdb.fragment.details.DetailsFragment
import com.satyaraj.app.tmdb.pojo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieFragment : BaseFragment<MainActivity>(), ClickListener, MovieContract.View {

    private var mMoviePresenter : MoviePresenter? = null
    private var mMovieAdapter : MovieAdapter? = null
    private var mProgressBar : ProgressBar? = null

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
        //These method can be replaced by data binding or butterKnife
        val mRecyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        mProgressBar = view.findViewById(R.id.progress_circular)
        mProgressBar?.visibility = View.VISIBLE

        val layoutManager = LinearLayoutManager(context)
        mRecyclerView.layoutManager = layoutManager

        mMovieAdapter = MovieAdapter(this)
        mRecyclerView.adapter = mMovieAdapter

        //We can avoid creating new options by using dagger
        val apiCall = MoviesApplication[parentActivity as MainActivity].appComponent?.apiCall
        val movieRepository = MovieRepository(CompositeDisposable(), apiCall!!)

        mMoviePresenter = MoviePresenter(this, movieRepository)
    }

    override fun displayMovies(movies: List<Movie>) {
        mMovieAdapter?.updateList(movies)
        mProgressBar?.visibility = View.GONE
    }

    override fun onItemClicked(movie: Movie) {
        parentActivity?.switchFragment(DetailsFragment.getNewInstance(movie.id.toString()), false)
    }
}