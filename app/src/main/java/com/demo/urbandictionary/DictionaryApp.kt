package com.demo.urbandictionary

import android.app.Application
import com.demo.urbandictionary.di.ApplicationComponent
import com.demo.urbandictionary.di.DaggerApplicationComponent
import com.demo.urbandictionary.di.NetworkModule
import com.demo.urbandictionary.util.AppLogger

class DictionaryApp : Application() {

  val applicationComponent by lazy { computeApplicationComponent() }

  override fun onCreate() {
    super.onCreate()

    AppLogger.init()
  }

  private fun computeApplicationComponent(): ApplicationComponent {
    return DaggerApplicationComponent.builder()
      .networkModule(NetworkModule())
      .build()
  }
}