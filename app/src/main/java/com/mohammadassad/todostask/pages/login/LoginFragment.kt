package com.mohammadassad.todostask.pages.login

import android.content.Context
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.util.Log

import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.marsad.stylishdialogs.StylishAlertDialog
import com.mohammadassad.todostask.R
import com.mohammadassad.todostask.alert.Alert
import com.mohammadassad.todostask.databinding.FragmentLoginBinding
import com.mohammadassad.todostask.routes.Screens
import com.mohammadassad.todostask.routes.navRoutes
import kotlinx.coroutines.coroutineScope


class LoginFragment : Fragment() , View.OnClickListener {

    var vm:LoginViewModel = LoginViewModel()
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        //hide status bar
        (activity as AppCompatActivity).supportActionBar?.hide()
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        _binding?.loginButton?.setOnClickListener(this)
        return binding.root

    }




    override fun onDestroyView() {
        super.onDestroyView()
        // calling this to avoid memory leak.
        _binding = null
    }

    override fun onClick(v: View) {

        _binding?.loginLoader?.isVisible = true
        _binding?.loginLoader?.bringToFront()

        vm.onLogin(email= _binding?.emailAddress?.text.toString(),password = _binding?.password?.text.toString())

        vm.isLoginSuccess.observe(viewLifecycleOwner, Observer{

            when(it){
                true->{
                    _binding?.loginLoader?.isVisible = false
                    navRoutes(findNavController(),Screens.LoginPageToHomePage.route)
                }
                else->{
                    Alert.showAlert(
                        title = "Something went wrong",
                        message="Email or Password are incorrect",
                        alertType = StylishAlertDialog.ERROR,
                        context= activity
                    )
                    _binding?.loginLoader?.isVisible = false
                }
            }


        })

    }


}