package com.bangkit.skinscan.data.remote

import com.bangkit.skinscan.data.remote.user.ApiServiceUser
import com.bangkit.skinscan.data.remote.user.request.RegisterRequest
import com.bangkit.skinscan.data.remote.user.response.RegisterResponse

class Repository private constructor(
    private val apiServiceUser: ApiServiceUser
){

    suspend fun register(request: RegisterRequest): RegisterResponse {
        return apiServiceUser.register(request)
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun clearInstance(){
            instance = null
        }

        fun getInstance(apiServiceUser: ApiServiceUser): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(apiServiceUser)
            }.also { instance = it }

        private const val TAG = "Repository"
    }
}