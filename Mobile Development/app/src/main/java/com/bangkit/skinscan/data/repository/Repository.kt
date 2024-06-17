package com.bangkit.skinscan.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.data.preference.UserPreference
import com.bangkit.skinscan.data.remote.ApiService
import com.bangkit.skinscan.data.remote.request.DeleteAccountRequest
import com.bangkit.skinscan.data.remote.request.LoginRequest
import com.bangkit.skinscan.data.remote.request.RegisterRequest
import com.bangkit.skinscan.data.remote.response.LoginResponse
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import kotlinx.coroutines.flow.Flow

class Repository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
){

    suspend fun register(request: RegisterRequest): RegisterResponse {
        return apiService.register(request)
    }

    suspend fun login(request: LoginRequest): LoginResponse {
        return apiService.login(request)
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

    suspend fun deleteAccount(request: DeleteAccountRequest): RegisterResponse {
        return apiService.deleteAccount(request)
    }

//    fun getArticle(): LiveData<PagingData<ListStoryItem>> {
//        return Pager(
//            config = PagingConfig(
//                pageSize = 5
//            ),
//            pagingSourceFactory = {
//                StoryPagingSource(apiService)
//            }
//        ).liveData
//    }

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun clearInstance(){
            instance = null
        }

        fun getInstance(apiService: ApiService, userPreference: UserPreference): Repository =
            instance ?: synchronized(this){
                instance ?: Repository(apiService, userPreference)
            }.also { instance = it }

        private const val TAG = "Repository"
    }
}