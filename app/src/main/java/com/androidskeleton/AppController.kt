package com.androidskeleton

import com.androidskeleton.di.components.AppComponent
import com.androidskeleton.di.components.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import dagger.android.DaggerApplication

class AppController : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        instance = this
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    override fun applicationInjector(): AppComponent {
        return DaggerAppComponent.builder().application(this).build()
    }

    companion object {
        @get:Synchronized
        var instance: AppController? = null
            private set
    }
}