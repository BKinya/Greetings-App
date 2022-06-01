package com.example.greetingsapp

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
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
import com.example.greetingsapp.viewmodel.GreetingsViewModel

private const val DATA_STORE_FILE_NAME = "user_profile.pb"
val Context.protoDataStore: DataStore<UserProfile> by dataStore(
  DATA_STORE_FILE_NAME,
  UserProfileSerializer
)

class MainActivity : AppCompatActivity() {

  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Disable Dark Mode
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setUpToolBar()
  }

  private fun setUpToolBar() {
    val toolbar = binding.toolbar
    setSupportActionBar(toolbar)

    val navController = findNavController(R.id.nav_host_fragment)
    appBarConfiguration = AppBarConfiguration(navController.graph)
    toolbar.setupWithNavController(navController, appBarConfiguration)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.menu_items, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val navController = findNavController(R.id.nav_host_fragment)
    return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
  }

}