package com.mohammadassad.todostask.models.Signup

data class SignupRequest (
    var name:String? = "",
    var email:String? = "",
    var password:String = ""
)