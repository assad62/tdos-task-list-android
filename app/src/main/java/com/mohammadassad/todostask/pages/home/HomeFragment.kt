package com.mohammadassad.todostask.pages.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.mohammadassad.todostask.R
import com.mohammadassad.todostask.databinding.FragmentHomeBinding
import com.mohammadassad.todostask.databinding.FragmentLoginBinding
import com.mohammadassad.todostask.pages.login.LoginViewModel
import com.mohammadassad.todostask.storage.LocalStorage


class HomeFragment : Fragment() {
    var vm: HomeViewModel =HomeViewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        (activity as AppCompatActivity).supportActionBar?.show()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding?.title?.text = "Hello ${LocalStorage.getStringValue("auth_token")}"

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // calling this to avoid memory leak.
        _binding = null
    }

}