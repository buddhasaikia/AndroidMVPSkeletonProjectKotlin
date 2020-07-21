package com.androidskeleton.module.ui.home;

import com.androidskeleton.di.scope.PerActivity;

import javax.inject.Inject;

@PerActivity
public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void sayHello(){
        view.greetings("Hello! I am presenter at your service!");
    }

    @Override
    public void takeView(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void dropView() {
        view = null;
    }
}
