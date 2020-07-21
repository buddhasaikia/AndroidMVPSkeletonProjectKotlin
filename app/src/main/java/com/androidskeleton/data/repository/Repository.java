package com.androidskeleton.data.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import com.androidskeleton.data.datasource.base.BaseDataSource;
import com.androidskeleton.data.datasource.base.DataSource;
import com.androidskeleton.data.datasource.LocalDataSource;

import javax.inject.Singleton;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by Buddha Saikia on 01-06-2017.
 */
@Singleton
public class Repository extends BaseDataSource implements DataSource {

    private static final String TAG = Repository.class.getSimpleName();
    private Context context;
    @NonNull
    private final DataSource remoteDataSource;
    @NonNull
    private final LocalDataSource localDataSource;

    public Repository(@NonNull Context context,
                      @NonNull DataSource awRemoteDataSource,
                      @NonNull LocalDataSource awLocalDataSource) {
        this.context = context;
        this.remoteDataSource = checkNotNull(awRemoteDataSource);
        this.localDataSource = checkNotNull(awLocalDataSource);
    }
}
