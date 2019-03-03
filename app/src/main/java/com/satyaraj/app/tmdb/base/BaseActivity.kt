package com.satyaraj.app.tmdb.base

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val mFragmentManager = supportFragmentManager
        if (mFragmentManager.backStackEntryCount > 1) {
            mFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }
}