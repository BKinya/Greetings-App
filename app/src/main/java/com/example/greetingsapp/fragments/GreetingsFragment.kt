package com.example.greetingsapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greetingsapp.R
import com.example.greetingsapp.databinding.FragmentGreetingsBinding
import com.example.greetingsapp.viewmodel.GreetingsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class GreetingsFragment : Fragment() {

  private var _binding: FragmentGreetingsBinding? = null
  private val binding get() = _binding!!

  private val greetingsViewModel: GreetingsViewModel by sharedViewModel()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentGreetingsBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    getUserProfile()
    observeProfile()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun getUserProfile() {
    greetingsViewModel.getUserProfile(requireContext())
  }

  private fun observeProfile() {
    greetingsViewModel.userProfile.observe(viewLifecycleOwner) { userProfile ->
      Log.d("What", "${userProfile.funFact}")
      val name = userProfile.name
      binding.greetingsTextView.text = getString(R.string.greeting, name )
    }
  }
}