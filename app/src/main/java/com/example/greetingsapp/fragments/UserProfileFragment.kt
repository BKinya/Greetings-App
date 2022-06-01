package com.example.greetingsapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.greetingsapp.databinding.FragmentUserProfileBinding
import com.example.greetingsapp.viewmodel.GreetingsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class UserProfileFragment : Fragment() {

  private var _binding: FragmentUserProfileBinding? = null
  private val binding get() = _binding!!

  private val greetingsViewModel: GreetingsViewModel by sharedViewModel()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
    return binding.root

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    observeUserprofile()

  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun observeUserprofile(){
    greetingsViewModel.userProfile.observe(viewLifecycleOwner){
      Log.d("UserprofileLogs", "name is ${it.name}")
      with(binding){
        nameEditTextProfile.setText(it.name)
        hobbyEditTextProfile.setText(it.hobby)
        funFactEditTextProfile.setText(it.funFact)
      }
    }
  }
}