package com.bangkit.skinscan.fragment.profile.resetpass

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.skinscan.data.remote.request.ResetPassRequest
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class ResetPassViewModel (private var repository: Repository): ViewModel() {
    private val _resetResult = MutableLiveData<RegisterResponse>()
    val resetResult: LiveData<RegisterResponse> = _resetResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun resetPass(email: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val request = ResetPassRequest(email)
                val response = repository.resetPass(request)
                _resetResult.value = response
            } catch (e: CancellationException) {
                Log.e(TAG, "Reset pass was cancelled: ${e.message}")
            }catch (e: Exception) {
                Log.e(TAG, "Reset pass failed: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    suspend fun logout(){
        repository.logout()
    }
    companion object {
        private const val TAG = "ResetPassViewModel"
    }
}