package com.androidskeleton.module.ui.home;


import com.androidskeleton.module.base.BasePresenter;
import com.androidskeleton.module.base.BaseView;

public interface HomeContract {
    interface View extends BaseView<Presenter> {

        void greetings(String message);
    }

    interface Presenter extends BasePresenter<View> {

        void sayHello();
    }
}
