package com.surya.android.application

import android.app.Application
import com.surya.android.di.applicationModule
import com.surya.android.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherFlowApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    initKoin()
  }

  private fun initKoin() {
    startKoin {
      androidLogger()
      androidContext(this@WeatherFlowApplication)
      modules(listOf(applicationModule, presentationModule))
    }
  }
}
