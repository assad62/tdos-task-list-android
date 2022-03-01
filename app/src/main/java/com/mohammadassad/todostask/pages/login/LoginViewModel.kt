package com.mohammadassad.todostask.pages.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammadassad.todostask.pages.login.service.LoginServiceImpl
import com.mohammadassad.todostask.storage.LocalStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {


    var isLoginSuccess = MutableLiveData<Boolean>()
    init {

    }


    fun onLogin( email:String, password:String){



        viewModelScope.launch(Dispatchers.IO){
            val res = LoginServiceImpl().login(email, password)
            if(res.isSuccessful && res.body() != null){
                val loginResponse = res.body()!!.body

                withContext(Dispatchers.Main){
                    loginResponse.token?.let {
                        LocalStorage.setStringValue("auth_token", it)
                    }
                    isLoginSuccess.value = true
                }

            }
            else{

                withContext(Dispatchers.Main){
                    isLoginSuccess.value = false
                }

            }
        }



    }
}