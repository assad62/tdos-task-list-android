package com.mohammadassad.todostask.pages.login.service

import com.mohammadassad.todostask.api.API
import com.mohammadassad.todostask.api.AuthService
import com.mohammadassad.todostask.models.Login.LoginRequest
import com.mohammadassad.todostask.models.Login.LoginResponse
import com.mohammadassad.todostask.models.StandardResponse
import retrofit2.Response

class LoginServiceImpl:LoginService {

    override suspend fun login(email: String, password: String): Response<StandardResponse<LoginResponse>> {
        val api = API.forService(AuthService::class.java)
        return api.login(LoginRequest(email,password))
    }
}