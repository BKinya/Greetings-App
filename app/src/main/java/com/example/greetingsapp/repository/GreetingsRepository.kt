package com.example.greetingsapp.repository

import android.content.Context
import com.example.greetingsapp.UserProfile
import com.example.greetingsapp.domain.User
import com.example.greetingsapp.protoDataStore
import kotlinx.coroutines.flow.Flow

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
  suspend fun getUserProfile(context: Context): Flow<UserProfile> = context.protoDataStore.data
}