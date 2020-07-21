package com.androidskeleton.module.main;

import com.androidskeleton.di.scope.FragmentScoped;
import com.androidskeleton.di.scope.PerActivity;
import com.androidskeleton.module.ui.home.HomeContract;
import com.androidskeleton.module.ui.home.HomeFragment;
import com.androidskeleton.module.ui.home.HomePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract HomeFragment mainFragment();

    @PerActivity
    @Binds
    abstract HomeContract.Presenter mainPresenter(HomePresenter presenter);
}
