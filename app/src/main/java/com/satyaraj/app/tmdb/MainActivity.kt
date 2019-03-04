package com.satyaraj.app.tmdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.satyaraj.app.tmdb.base.BaseActivity
import com.satyaraj.app.tmdb.custom.FragmentTransactionManager
import com.satyaraj.app.tmdb.fragment.movielist.MovieFragment

class MainActivity :  BaseActivity() {

    /**
     * Method which is called when the application is launched
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Checking if the instance is already present, useful when you rotate the device
        if (savedInstanceState == null) {
            switchFragment(MovieFragment.getNewInstance(), false)
        }
    }

    /**
     * This method is used to switch to any fragment
     * @see BaseActivity This fragment should be the instance of this class
     * @param fragment This fragment you want to switch to
     * @param shouldPop This boolean tells if you want to pop the current fragment before switching
     */
    fun switchFragment(fragment: Fragment, shouldPop: Boolean) {
        FragmentTransactionManager.addFragment(supportFragmentManager, fragment, shouldPop, R.id.container)
    }
}
