package com.satyaraj.app.tmdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.satyaraj.app.tmdb.base.BaseActivity
import com.satyaraj.app.tmdb.custom.FragmentTransactionManager
import com.satyaraj.app.tmdb.fragment.movielist.MovieFragment

class MainActivity :  BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            switchFragment(MovieFragment.getNewInstance(), false)
        }
    }

    fun switchFragment(fragment: Fragment, shouldPop: Boolean) {
        FragmentTransactionManager.addFragment(supportFragmentManager, fragment, shouldPop, R.id.container)
    }
}
