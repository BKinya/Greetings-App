package com.example.greetingsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.greetingsapp.R
import com.example.greetingsapp.databinding.FragmentGreetingsBinding
import com.example.greetingsapp.translations
import com.example.greetingsapp.viewmodel.GreetingsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GreetingsFragment : Fragment() {

  private var _binding: FragmentGreetingsBinding? = null
  private val binding get() = _binding!!
  private val greetingsViewModel: GreetingsViewModel by sharedViewModel()
  private var name = "Android"
  private var greeting = "Hi"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentGreetingsBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setUpToolBar()
    getUserProfile()
    observeProfile()
    getLanguage()
    observeLanguage()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setUpToolBar() {
    val toolbar = binding.toolbar
    // Inflate the Menu
    toolbar.inflateMenu(R.menu.menu_items)
    setToolBarItemClicked()
  }

  private fun setToolBarItemClicked(){
    binding.toolbar.setOnMenuItemClickListener {
      when(it.itemId){
        R.id.languageItem ->{
          createPopUpMenu()
          true
        }
        R.id.profileItem ->{
          goToUserProfile()
          true
        }
        else -> { false}
      }
    }
  }

  private fun createPopUpMenu(){
    val popupMenu = PopupMenu(requireContext(), binding.toolbar)
    popupMenu.menuInflater.inflate(R.menu.languages_popup_menu, popupMenu.menu)
    popupMenu.setOnMenuItemClickListener { item ->
      greetingsViewModel.saveLanguage(item.toString(), requireContext())
      true
    }
    popupMenu.show()
  }
  private fun goToUserProfile(){
    findNavController().navigate(R.id.action_greetingsFragment_to_userProfileFragment)
  }
  private fun getUserProfile() {
    greetingsViewModel.getUserProfile(requireContext())
  }

  private fun observeProfile() {
    greetingsViewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
      name = userProfile.name
    }
  }

  private fun getLanguage(){
    greetingsViewModel.getLanguage(requireContext())
  }

  private fun observeLanguage(){
    greetingsViewModel.language.observe(viewLifecycleOwner){ language ->
      val menuItem = binding.toolbar.menu.findItem(R.id.languageItem)
      if (language != null){
        menuItem.title = language
        greeting = getGreeting(language) ?: "Hi"
        showGreetings()
      }else{
        menuItem.title = "Select Language"
      }
    }
  }

  private fun getGreeting(language: String) = translations[language]

  private fun showGreetings(){
    binding.greetingsTextView.text = "$greeting $name!"
  }

}