package com.bangkit.skinscan.view.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.data.remote.request.LoginRequest
import com.bangkit.skinscan.data.remote.response.LoginResponse
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: Repository): ViewModel() {
    private val _loginResult = MutableLiveData<LoginResponse>()
    val loginResult: LiveData<LoginResponse> = _loginResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun login(email: String, pass: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val request = LoginRequest(email, pass)
                val response = repository.login(request)
                _loginResult.value = response
            } catch (e: Exception) {
                Log.e(TAG, "Login failed: ${e.message}")
            } finally {
                _isLoading.value = false
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