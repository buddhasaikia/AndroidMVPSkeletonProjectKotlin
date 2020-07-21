package com.androidskeleton.data.repository

import android.content.Context
import com.androidskeleton.data.datasource.LocalDataSource
import com.androidskeleton.data.datasource.base.BaseDataSource
import com.androidskeleton.data.datasource.base.DataSource
import dagger.internal.Preconditions
import javax.inject.Singleton

/**
 * Created by Buddha Saikia on 01-06-2017.
 */
@Singleton
class Repository(private val context: Context,
                 awRemoteDataSource: DataSource,
                 awLocalDataSource: LocalDataSource) : BaseDataSource(), DataSource {
    private val remoteDataSource: DataSource
    private val localDataSource: LocalDataSource

    companion object {
        private val TAG = Repository::class.java.simpleName
    }

    init {
        remoteDataSource = Preconditions.checkNotNull(awRemoteDataSource)
        localDataSource = Preconditions.checkNotNull(awLocalDataSource)
    }
}