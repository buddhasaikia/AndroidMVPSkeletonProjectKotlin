package com.androidskeleton.di.module

import android.content.Context
import com.androidskeleton.BuildConfig
import com.androidskeleton.data.api.ApiService
import com.androidskeleton.data.datasource.LocalDataSource
import com.androidskeleton.data.datasource.RemoteDataSource
import com.androidskeleton.data.repository.Repository
import com.androidskeleton.util.ErrorMessageFactory
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideStethoInterceptor(): StethoInterceptor {
        return StethoInterceptor()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    @Named("ok-1")
    fun provideOkHttpClient1(loggingInterceptor: HttpLoggingInterceptor,
                             stethoInterceptor: StethoInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(stethoInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    @Named("ok-2")
    fun provideOkHttpClient2(loggingInterceptor: HttpLoggingInterceptor,
                             stethoInterceptor: StethoInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addNetworkInterceptor(stethoInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("ok-1") okHttpClient: OkHttpClient,
                        converterFactory: GsonConverterFactory,
                        adapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.URL_HOST_API)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideErrorMessageFactory(context: Context?): ErrorMessageFactory {
        return ErrorMessageFactory(context)
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(): LocalDataSource {
        return LocalDataSource()
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @Singleton
    @Provides
    fun provideRepository(context: Context?, localDatasource: LocalDataSource, remoteDatasource: RemoteDataSource): Repository {
        return Repository(context!!, remoteDatasource, localDatasource)
    }
}