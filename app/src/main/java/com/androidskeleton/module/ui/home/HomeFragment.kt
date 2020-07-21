package com.androidskeleton.module.ui.home

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.androidskeleton.R
import com.androidskeleton.di.scope.PerActivity
import com.androidskeleton.module.base.DaggerBaseFragment
import com.androidskeleton.module.ui.home.HomeContract.Presenter
import javax.inject.Inject

@PerActivity
class HomeFragment : DaggerBaseFragment(), HomeContract.View {
    private var mListener: OnFragmentInteractionListener? = null

    @JvmField
    @Inject
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return rootView
    }

    fun onButtonPressed(uri: Uri?) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun greetings(message: String?) {
        val lblGreetings = rootView?.findViewById<TextView>(R.id.lbl_greetings)
        lblGreetings?.text = message
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri?)
    }

    override fun onResume() {
        super.onResume()
        presenter?.takeView(this)
        presenter?.sayHello()
    }

    override fun onPause() {
        presenter?.dropView()
        super.onPause()
    }

    override val layoutId = R.layout.fragment_main

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}