package com.androidskeleton.di.components

import android.app.Application
import com.androidskeleton.di.module.ActivityBindingModule
import com.androidskeleton.di.module.AppModule
import com.androidskeleton.di.module.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Buddha Saikia on 05-06-2017.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class, RepositoryModule::class])
interface AppComponent : AndroidInjector<DaggerApplication?> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application?): Builder

        fun build(): AppComponent
    }
}