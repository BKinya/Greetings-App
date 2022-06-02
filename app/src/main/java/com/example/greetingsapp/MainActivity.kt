package com.example.greetingsapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.greetingsapp.databinding.ActivityMainBinding
import com.example.greetingsapp.serializers.UserProfileSerializer


private const val DATA_STORE_FILE_NAME = "user_profile.pb"
val LANGUAGE_KEY = stringPreferencesKey("language")
val Context.protoDataStore: DataStore<UserProfile> by dataStore(
  DATA_STORE_FILE_NAME,
  UserProfileSerializer
)
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Disable Dark Mode
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }
}