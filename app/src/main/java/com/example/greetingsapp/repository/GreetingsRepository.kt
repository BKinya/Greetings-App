package com.example.greetingsapp.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.greetingsapp.LANGUAGE_KEY
import com.example.greetingsapp.UserProfile
import com.example.greetingsapp.dataStore
import com.example.greetingsapp.domain.User
import com.example.greetingsapp.protoDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.intellij.lang.annotations.Language

class GreetingsRepository{
  suspend fun saveUserProfile(user: User, context: Context) {
    context.protoDataStore.updateData {userProfile ->
      userProfile.toBuilder()
        .setFunFact(user.funFact)
        .setHobby(user.hobby)
        .setName(user.name)
        .build()
    }
  }

  /**
   * DataStore.data to expose a Flow UserProfile Object
   */
  fun getUserProfile(context: Context): Flow<UserProfile> = context.protoDataStore.data

  suspend fun saveLanguage(language: String, context: Context){
    context.dataStore.edit { settings ->
      settings[LANGUAGE_KEY] = language

    }
  }

  fun getLanguage(context: Context): Flow<String?>{
   return context.dataStore.data.map { settings ->
      settings[LANGUAGE_KEY]
    }
  }
}