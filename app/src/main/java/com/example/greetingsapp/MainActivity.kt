package com.example.greetingsapp

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.greetingsapp.databinding.ActivityMainBinding
import com.example.greetingsapp.serializers.UserProfileSerializer

private const val DATA_STORE_FILE_NAME = "user_profile.pb"
val Context.protoDataStore: DataStore<UserProfile> by dataStore(
  DATA_STORE_FILE_NAME,
  UserProfileSerializer
)

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