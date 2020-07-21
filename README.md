# AndroidSkeletonProject
AndroidSkeleton is a boilerplate project to start with MVP, Dagger 2.11, RxJava 2, Splash screen, Fresco with Kotlin support.

## The following libraries have already been included
* [Dagger2](https://github.com/google/dagger)
* [Retrofit 2](https://github.com/square/retrofit)
* [RxAndroid](https://github.com/ReactiveX/RxAndroid)
* RxandroidAdapter (Depricated)
* [RxJava 2](https://github.com/ReactiveX/RxJava)
* [LoggingInterceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
* [Stetho](https://github.com/facebook/stetho)
* [Fresco](https://github.com/facebook/fresco)
* [FindBugs](http://findbugs.sourceforge.net/)

## build.gradle (App)

**Product flavours-** _dev, prod, mock_

**minifyEnabled-** _true_

**Proguard filed added-** _'proguard-rules.pro','proguard-fresco.pro','proguard-rxjava.pro'_

## version.properties

This file track incremental build number value. Don't forget to reset ```VERSION_CODE``` value to 0.

