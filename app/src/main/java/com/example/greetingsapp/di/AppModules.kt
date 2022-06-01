package com.example.greetingsapp.di

import com.example.greetingsapp.viewmodel.GreetingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
  viewModel{ GreetingsViewModel()}
}