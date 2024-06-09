package com.bangkit.skinscan.data.repository

import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.data.preference.UserPreference
import com.bangkit.skinscan.data.remote.user.ApiServiceUser
import com.bangkit.skinscan.data.remote.user.request.LoginRequest
import com.bangkit.skinscan.data.remote.user.request.RegisterRequest
import com.bangkit.skinscan.data.remote.user.response.LoginResponse
import com.bangkit.skinscan.data.remote.user.response.RegisterResponse
import kotlinx.coroutines.flow.Flow

class Repository private constructor(
    private val apiServiceUser: ApiServiceUser,
    private val userPreference: UserPreference
){

    suspend fun register(request: RegisterRequest): RegisterResponse {
        return apiServiceUser.register(request)
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        return apiServiceUser.login(request)
    }

    suspend fun saveSession(userModel: UserModel){
        userPreference.saveSession(userModel)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout(){
        userPreference.logout()
    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun clearInstance(){
            instance = null
        }

        fun getInstance(apiServiceUser: ApiServiceUser, userPreference: UserPreference): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(apiServiceUser, userPreference)
            }.also { instance = it }

        private const val TAG = "Repository"
    }
}