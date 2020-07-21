package com.androidskeleton.di.module

import com.androidskeleton.di.scope.PerActivity
import com.androidskeleton.module.ui.main.MainActivity
import com.androidskeleton.module.ui.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity?
}