package com.example.greetingsapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.greetingsapp.R
import com.example.greetingsapp.databinding.FragmentRegisterBinding
import com.example.greetingsapp.domain.User
import com.example.greetingsapp.viewmodel.GreetingsViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class RegisterFragment : Fragment() {
  private var _binding: FragmentRegisterBinding? = null
  private val binding get() = _binding!!

  private val greetingsViewModel: GreetingsViewModel by viewModel()
  var language = "English"

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentRegisterBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setUpLanguageDropDown()
    setSaveBtnClickListener()
    setSkipBtnClicked()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun setUpLanguageDropDown() {
    val items = listOf("English", "Kiswahili", "Kimeru")
    val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
    binding.languageEdiText.setAdapter(adapter)
  }

  private fun setSaveBtnClickListener(){
    binding.registerBtn.setOnClickListener {
      validateAndSave()
      goToGreetingsFragment()
    }
  }

  private fun setSkipBtnClicked(){
    binding.skipBtn.setOnClickListener {
      goToGreetingsFragment()
    }
  }

  private fun goToGreetingsFragment(){
    findNavController().navigate(R.id.action_registerFragment_to_greetingsFragment)
  }

  private fun validateAndSave() {
    with(binding) {
      val name = nameEditText.text.toString()
      val hobby = hobbyEditText.text.toString()
      val funFact = funFactEditText.text.toString()
      val selectedLanguage = languageEdiText.text.toString()
      Log.d("RegisterFragmentLogs", "language  is $selectedLanguage")

      val isValid = isValidString(name) && isValidString(hobby) && isValidString(funFact)
      if (isValid) {
        val user = User(
          name = name,
          hobby = hobby,
          funFact = funFact
        )
        if (isValidString(selectedLanguage)){
          language = selectedLanguage
        }
        greetingsViewModel.saveUserProfile(user, language, requireContext())
      } else {
        Snackbar.make(binding.root, "All fields are required", Snackbar.LENGTH_LONG).show()
      }
    }
  }

  private fun isValidString(text: String?): Boolean {
    var isValid = false
    if (text != null && text.isNotEmpty()){
      isValid = true
    }
    return isValid
  }
}