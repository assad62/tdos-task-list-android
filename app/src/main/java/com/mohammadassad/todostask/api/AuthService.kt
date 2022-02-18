package com.mohammadassad.todostask.api

import com.mohammadassad.todostask.models.Login.LoginRequest
import com.mohammadassad.todostask.models.Login.LoginResponse
import com.mohammadassad.todostask.models.StandardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthService {
    @Headers("Content-Type:application/json")
    @POST("/api/v1/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<StandardResponse<LoginResponse>>

}