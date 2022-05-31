package com.example.greetingsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.greetingsapp.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
  private var _binding: FragmentRegisterBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View{
    _binding = FragmentRegisterBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val items = listOf("English", "Kiswahili", "Kimeru", )
    val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
    binding.test.setAdapter(adapter)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}