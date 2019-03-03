package com.satyaraj.app.tmdb.base

import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {

    var parentActivity: BaseActivity? = null

    protected fun attachParent(parentActivity: BaseActivity) {
        this.parentActivity = parentActivity
    }

}