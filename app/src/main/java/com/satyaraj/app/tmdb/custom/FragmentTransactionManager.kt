package com.satyaraj.app.tmdb.custom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object FragmentTransactionManager {

    @Synchronized
    fun addFragment(mFragmentManager: FragmentManager,
        fragment: Fragment,
        popStack: Boolean,
        container: Int
    ) {
        if (!mFragmentManager.isDestroyed) {
            if (popStack) {
                mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
            val ft = mFragmentManager.beginTransaction()
            ft.add(container, fragment)
            ft.commitAllowingStateLoss()
            ft.addToBackStack(null)
            mFragmentManager.executePendingTransactions()
        }
    }
}