package com.bangkit.skinscan.data.remote

import com.bangkit.skinscan.data.remote.request.LoginRequest
import com.bangkit.skinscan.data.remote.request.RegisterRequest
import com.bangkit.skinscan.data.remote.response.LoginResponse
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}