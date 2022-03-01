package com.mohammadassad.todostask.models.Signup

import com.google.gson.annotations.SerializedName

data class SignupResponse (
    @SerializedName("name"  ) var name  : String? = null,
)
