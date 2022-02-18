package com.mohammadassad.todostask.pages.login.service

import com.mohammadassad.todostask.models.Login.LoginResponse
import com.mohammadassad.todostask.models.StandardResponse
import retrofit2.Response

interface LoginService {
    suspend fun login(email:String, password:String): Response<StandardResponse<LoginResponse>>
}