package com.androidskeleton.module.ui.main

import android.net.Uri
import android.os.Bundle
import com.androidskeleton.R
import com.androidskeleton.module.base.DaggerBaseActivity
import com.androidskeleton.module.ui.home.HomeFragment
import com.androidskeleton.module.ui.home.HomeFragment.OnFragmentInteractionListener
import com.androidskeleton.util.ActivityUtils.addFragmentToActivity

class MainActivity : DaggerBaseActivity(), OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainFragment = HomeFragment.newInstance()
        addFragmentToActivity(supportFragmentManager, mainFragment, R.id.container)
    }

    override fun onFragmentInteraction(uri: Uri?) {}

    override val layoutId = R.layout.activity_main
}