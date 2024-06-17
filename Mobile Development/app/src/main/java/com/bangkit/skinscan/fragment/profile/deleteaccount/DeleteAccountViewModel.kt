package com.bangkit.skinscan.fragment.profile.deleteaccount

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.skinscan.data.remote.request.DeleteAccountRequest
import com.bangkit.skinscan.data.remote.response.RegisterResponse
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class DeleteAccountViewModel (private var repository: Repository): ViewModel() {
    private val _deleteResult = MutableLiveData<RegisterResponse>()
    val deleteResult: LiveData<RegisterResponse> = _deleteResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun deleteAccount(email: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val request = DeleteAccountRequest(email)
                val response = repository.deleteAccount(request)
                _deleteResult.value = response
            } catch (e: CancellationException) {
                Log.e(TAG, "Delete account was cancelled: ${e.message}")
            }catch (e: Exception) {
                Log.e(TAG, "Delete account failed: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    suspend fun logout(){
        repository.logout()
    }
    companion object {
        private const val TAG = "DeleteAccountViewModel"
    }
}