package com.satyaraj.app.tmdb.fragment.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.satyaraj.app.tmdb.MainActivity
import com.satyaraj.app.tmdb.R
import com.satyaraj.app.tmdb.base.BaseFragment
import com.satyaraj.app.tmdb.pojo.Movie

class MovieFragment : BaseFragment<MainActivity>(), ClickListener {

    private var mRecyclerView: RecyclerView? = null
    private var mMovieAdapter: MovieAdapter? = null

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
    }

    private fun initViews(view: View) {
        mRecyclerView = view.findViewById(R.id.recycler_view)
        mMovieAdapter = MovieAdapter(this)
    }

    fun displayMovies(movies: List<Movie>) {
        mMovieAdapter?.updateList(movies)
    }

    override fun onItemClicked(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}