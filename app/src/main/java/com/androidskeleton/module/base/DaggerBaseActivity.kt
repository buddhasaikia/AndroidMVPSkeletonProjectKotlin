package com.androidskeleton.module.base

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

abstract class DaggerBaseActivity : DaggerAppCompatActivity() {
    protected abstract val layoutId: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}