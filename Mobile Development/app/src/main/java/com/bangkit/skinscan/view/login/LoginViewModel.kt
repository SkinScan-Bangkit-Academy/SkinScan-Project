package com.bangkit.skinscan.view.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.data.remote.user.request.LoginRequest
import com.bangkit.skinscan.data.remote.user.response.LoginResponse
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository): ViewModel() {
    val loginResult = MutableLiveData<LoginResponse>()
//    val isLoading = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
//        isLoading.value = true
        viewModelScope.launch {
            try {
                val request = LoginRequest(email, pass)
                val response = repository.login(request)
                loginResult.value = response
            } catch (e: Exception) {
                Log.e(TAG, "Login failed: ${e.message}")
            } finally {
//                isLoading.value = false
            }
        }
    }

    suspend fun saveSession(user: UserModel) {
        repository.saveSession(user)
    }


    companion object {
        private const val TAG = "LoginViewModel"
    }
}