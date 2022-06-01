package com.example.greetingsapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greetingsapp.UserProfile
import com.example.greetingsapp.domain.User
import com.example.greetingsapp.repository.GreetingsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class GreetingsViewModel() : ViewModel() {
  private val repository = GreetingsRepository()
  private val _userProfile = MutableLiveData<UserProfile>()
  val userProfile: LiveData<UserProfile>
    get() = _userProfile

  private val _language = MutableLiveData<String?>()
  val language: LiveData<String?>
  get() = _language


  fun saveUserProfile(user: User, language: String, context: Context) {
    viewModelScope.launch {
      repository.saveUserProfile(user, context)
      repository.saveLanguage(language, context)
    }
  }

  fun getUserProfile(context: Context) {
    viewModelScope.launch {
      val profile = repository.getUserProfile(context)
      profile.collect {
        _userProfile.value = it
      }
    }
  }

  fun saveLanguage(language: String ,context: Context){
    viewModelScope.launch {
      repository.saveLanguage(language, context)
    }
  }

  fun getLanguage(context: Context){
   viewModelScope.launch {
     repository.getLanguage(context).collect {
     _language.postValue(it)
     }
   }
  }

}