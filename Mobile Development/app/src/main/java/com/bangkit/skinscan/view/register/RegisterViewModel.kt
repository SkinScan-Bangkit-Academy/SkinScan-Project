package com.bangkit.skinscan.view.register

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.skinscan.data.remote.request.RegisterRequest
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.launch

class RegisterViewModel(private var repository: Repository): ViewModel() {
    private val _registerResult = MutableLiveData<RegisterResponse>()
    val registerResult: LiveData<RegisterResponse> = _registerResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    fun register(name: String, email: String, pass: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val request = RegisterRequest(name, email, pass)
                val response = repository.register(request)
                _registerResult.value = response
            } catch (e: Exception) {
                Log.e(TAG, "Register failed: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    companion object {
        private const val TAG = "RegisterViewModel"
    }
}