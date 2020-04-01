package com.demo.urbandictionary.di

import android.content.Context
import com.demo.urbandictionary.BuildConfig
import com.demo.urbandictionary.data.remote.DictionaryService
import com.jakewharton.byteunits.DecimalByteUnit
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

  @Singleton
  @Provides
  fun provideCache(context: Context): Cache {
    return Cache(context.cacheDir, DecimalByteUnit.MEGABYTES.toBytes(5))
  }

  @Singleton
  @Provides
  fun provideOkHttp(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
      .connectTimeout(15, TimeUnit.SECONDS)
      .readTimeout(15, TimeUnit.SECONDS)
      .writeTimeout(15, TimeUnit.SECONDS)
      .addInterceptor(interceptor)
      .build()
  }

  @Singleton
  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .client(okHttpClient)
      .baseUrl(BuildConfig.RAPID_URL_API)
      .build()
  }

  @Singleton
  @Provides
  fun provideDictionaryService(retrofit: Retrofit): DictionaryService {
    return retrofit.create(DictionaryService::class.java)
  }
}