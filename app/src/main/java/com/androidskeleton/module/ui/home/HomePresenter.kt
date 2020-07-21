package com.androidskeleton.module.ui.home

import com.androidskeleton.di.scope.PerActivity
import com.androidskeleton.module.ui.home.HomeContract.Presenter
import javax.inject.Inject

@PerActivity
class HomePresenter @Inject constructor() : Presenter {
    private var view: HomeContract.View? = null

    override fun sayHello() {
        view?.greetings("Hello! I am presenter at your service!")
    }

    override fun takeView(view: HomeContract.View?) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }
}