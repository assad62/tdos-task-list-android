package com.mohammadassad.todostask.pages.signup

import androidx.lifecycle.ViewModel
import com.mohammadassad.todostask.services.validate_data_service.ValidationService

class SignupViewModel:ViewModel() {



    init {

    }

    fun onSignup( name:String,email:String,password:String){

    }



    fun validateName(name:String):Boolean{

        if( (name.isNotEmpty()) ){
            return true
        }
        return false

    }

    fun validateEmail(email:String):Boolean{
        return ValidationService.isEmailValid(email)

    }

    fun validatePassword(password: String):Boolean{
        if( (6 <= password.length) && (password.length <= 8) ){
            return true
        }
        return false
    }
}