package com.example.greetingsapp

import android.app.Application
import com.example.greetingsapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GreetingsApplication: Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin{
      androidLogger()
      androidContext(this@GreetingsApplication)
      modules(appModules)
    }
  }
}