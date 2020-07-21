package com.androidskeleton.util

import android.accounts.NetworkErrorException
import android.content.Context
import com.androidskeleton.BuildConfig
import com.androidskeleton.R
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * Created by Buddha Saikia on 03-05-2017.
 */
class ErrorMessageFactory(private val context: Context?) {
    fun getError(t: Throwable): String {
        t.printStackTrace()
        var msg = ""
        if (context != null) {
            if ((t is ConnectException || t is UnknownHostException || t is NetworkErrorException)){
                msg = context.resources.getString(R.string.internet_error)
            } else if (t is java.net.SocketTimeoutException || t is java.net.NoRouteToHostException){
                msg = context.resources.getString(R.string.error_unable_to_connect_to_the_server_try_again)
            } else {
                msg = context.getString(R.string.error_something_went_wrong_try_again)
            }
        }
        //Firebase crash reporting
        if (!BuildConfig.DEBUG) {
            //FirebaseCrash.report(t);
        }
        return msg
    }

}