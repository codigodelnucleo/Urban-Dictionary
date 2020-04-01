package com.demo.urbandictionary.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class NetworkTools {

//    companion object {
//        fun hasNetwork(context: Context): Boolean? {
//            var isConnected: Boolean? = false
//            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
//            if (activeNetwork != null && activeNetwork.isConnected)
//                isConnected = true
//            return isConnected
//        }
//        fun  getHttpClient (context: Context? = null) : OkHttpClient?
//        {
//            var okHttpClient: OkHttpClient
//            val cacheSize = 5 * 1024 * 1024
//
//            if (context != null) {
//                val myCache = Cache(context.cacheDir, cacheSize.toLong())
//                okHttpClient = OkHttpClient.Builder()
//                    .cache(myCache)
//                    .addInterceptor { chain ->
//                        var request = chain.request()
//                        request = if (hasNetwork(context)!!)
//                            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
//                        else
//                            request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
//                        chain.proceed(request)
//                    }
//                    .build()
//            }
//            else
//            {
//                okHttpClient = OkHttpClient.Builder()
//                    .connectTimeout(15, TimeUnit.SECONDS)
//                    .readTimeout(15, TimeUnit.SECONDS)
//                    .writeTimeout(15, TimeUnit.SECONDS)
//                    .build()
//            }
//            return okHttpClient
//        }
//    }


}