package com.example.greetingsapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingsapp.UserProfile
import com.example.greetingsapp.domain.User
import com.example.greetingsapp.repository.GreetingsRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GreetingsViewModel() : ViewModel() {
  private val repository = GreetingsRepository()
  private val _userProfile = MutableLiveData<UserProfile>()
  val userProfile: LiveData<UserProfile> get() = _userProfile
  fun saveUserProfile(user: User, context: Context) {
    viewModelScope.launch {
      repository.saveUserProfile(user, context)
    }
  }

  fun getUserProfile(context: Context) {
    viewModelScope.launch {
      val profile = repository.getUserProfile(context)
      profile.map {
        _userProfile.value = it
      }
    }
  }
}