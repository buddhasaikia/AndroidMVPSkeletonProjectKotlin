package com.androidskeleton.data.datasource

import com.androidskeleton.data.api.ApiService
import com.androidskeleton.data.datasource.base.BaseDataSource
import com.androidskeleton.data.datasource.base.DataSource

/**
 * Created by Buddha Saikia on 03-06-2017.
 */
class RemoteDataSource(private val apiService: ApiService) : BaseDataSource(), DataSource