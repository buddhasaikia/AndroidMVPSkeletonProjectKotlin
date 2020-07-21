package com.androidskeleton.module.ui.main

import com.androidskeleton.di.scope.FragmentScoped
import com.androidskeleton.di.scope.PerActivity
import com.androidskeleton.module.ui.home.HomeContract.Presenter
import com.androidskeleton.module.ui.home.HomeFragment
import com.androidskeleton.module.ui.home.HomePresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun mainFragment(): HomeFragment?

    @PerActivity
    @Binds
    abstract fun mainPresenter(presenter: HomePresenter?): Presenter?
}