package com.bangkit.skinscan.view.register

import androidx.lifecycle.ViewModel
import com.bangkit.skinscan.data.remote.user.request.RegisterRequest
import com.bangkit.skinscan.data.remote.user.response.RegisterResponse
import com.bangkit.skinscan.data.repository.Repository

class RegisterViewModel(private var repository: Repository): ViewModel() {
    suspend fun register(
        request: RegisterRequest
    ): RegisterResponse {
        return repository.register(request)
    }
}