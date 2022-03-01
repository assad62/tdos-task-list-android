package com.mohammadassad.todostask.services.validate_data_service

import android.text.TextUtils

object ValidationService {
    fun isEmailValid(email:String): Boolean {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}