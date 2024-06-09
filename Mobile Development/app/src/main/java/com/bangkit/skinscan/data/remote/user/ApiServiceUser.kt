package com.bangkit.skinscan.data.remote.user

import com.bangkit.skinscan.data.remote.user.request.RegisterRequest
import com.bangkit.skinscan.data.remote.user.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceUser {
    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse
}