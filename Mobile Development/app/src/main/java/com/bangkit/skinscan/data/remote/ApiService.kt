package com.bangkit.skinscan.data.remote

import com.bangkit.skinscan.data.remote.request.ResetPassRequest
import com.bangkit.skinscan.data.remote.request.LoginRequest
import com.bangkit.skinscan.data.remote.request.RegisterRequest
import com.bangkit.skinscan.data.remote.response.Article
import com.bangkit.skinscan.data.remote.response.ArticleResponse
import com.bangkit.skinscan.data.remote.response.LoginResponse
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("reset-password")
    suspend fun resetPass(
        @Body request: ResetPassRequest
    ): RegisterResponse

    @GET("article")
    suspend fun getArticle(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): ArticleResponse
}