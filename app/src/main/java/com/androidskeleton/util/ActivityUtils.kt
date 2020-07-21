/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.androidskeleton.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.androidskeleton.R

object ActivityUtils {
    @JvmStatic
    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
        transaction.replace(frameId, fragment)
        transaction.commitAllowingStateLoss()
    }

    fun addFragmentToActivityKeepHistory(fragmentManager: FragmentManager,
                                         fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, android.R.animator.fade_in, android.R.animator.fade_out)
        transaction.replace(frameId, fragment)
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun addFragmentToActivityAnimUpDown(fragmentManager: FragmentManager,
                                        fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up, R.animator.slide_out_up, R.animator.slide_out_up)
        transaction.replace(frameId, fragment)
        transaction.commitAllowingStateLoss()
    }

    fun addFragmentToActivityKeepHistoryAnimUpDown(fragmentManager: FragmentManager,
                                                   fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.animator.slide_in_up, R.animator.slide_out_up, R.animator.slide_out_down, R.animator.slide_in_down)
        transaction.replace(frameId, fragment)
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }

    fun addFragmentToActivityKeepHistoryAnimFadeInSlideDown(fragmentManager: FragmentManager,
                                                            fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out, R.animator.slide_out_down, R.animator.slide_in_down)
        transaction.replace(frameId, fragment)
        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }
}