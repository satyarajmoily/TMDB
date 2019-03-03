package com.satyaraj.app.tmdb.fragment.movielist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.satyaraj.app.tmdb.R
import com.satyaraj.app.tmdb.pojo.Movie
import java.util.ArrayList

class MovieAdapter(movieFragment: MovieFragment) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mMoviesList = ArrayList<Movie>(0)

    private val mClickListener: ClickListener
    private val mContext: Context

    init {
        this.mClickListener = movieFragment
        this.mContext = movieFragment.context!!
    }

    internal fun updateList(movieList: List<Movie>) {
        mMoviesList.clear()
        mMoviesList.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder: RecyclerView.ViewHolder
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        viewHolder = ViewHeader(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = mMoviesList[position]
        (holder as ViewHeader).onBind(story)
    }

    override fun getItemCount(): Int {
        return mMoviesList.size
    }

    private inner class ViewHeader internal constructor(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val movieTitle : TextView = view.findViewById(R.id.movie_title)
        val poster : ImageView = view.findViewById(R.id.movie_poster)
        val movieDesc: TextView = view.findViewById(R.id.movie_desc)
        val movieRating : TextView = view.findViewById(R.id.movie_rating)
        val movieDate : TextView = view.findViewById(R.id.movie_release_date)
        val movieLanguage : TextView = view.findViewById(R.id.movie_lang)

        init {
            view.setOnClickListener(this)
        }

        private lateinit var mMovie: Movie

        internal fun onBind(movie: Movie) {
            this.mMovie = movie
            movieTitle.text = mMovie.movieTitle
            movieDesc.text = mMovie.movieDesc
            movieRating.text = mMovie.movieRating
            movieDate.text = mMovie.movieDate
            movieLanguage.text = mMovie.movieLang

            Glide.with(mContext)
                .load(movie.url)
                .placeholder(R.drawable.abc_ab_share_pack_mtrl_alpha)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(poster)
        }

        override fun onClick(view: View) {
            mClickListener.onItemClicked(mMovie)
        }
    }
}
