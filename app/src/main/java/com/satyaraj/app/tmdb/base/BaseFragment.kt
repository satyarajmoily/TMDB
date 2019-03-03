package com.satyaraj.app.tmdb.base

import androidx.fragment.app.Fragment


abstract class BaseFragment <T:BaseActivity> : Fragment() {

    var parentActivity: T? = null

    protected fun attachParent(parentActivity: T) {
        this.parentActivity = parentActivity
    }

}