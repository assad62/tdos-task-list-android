package com.mohammadassad.todostask.models.Login

import com.google.gson.annotations.SerializedName


data class LoginResponse (

    @SerializedName("name"  ) var name  : String? = null,
    @SerializedName("token" ) var token : String? = null

)