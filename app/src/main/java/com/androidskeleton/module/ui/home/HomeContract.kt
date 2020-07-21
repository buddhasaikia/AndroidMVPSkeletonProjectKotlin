package com.androidskeleton.module.ui.home

import com.androidskeleton.module.base.BasePresenter
import com.androidskeleton.module.base.BaseView

interface HomeContract {
    interface View : BaseView<Presenter?> {
        fun greetings(message: String?)
    }

    interface Presenter : BasePresenter<View?> {
        fun sayHello()
    }
}