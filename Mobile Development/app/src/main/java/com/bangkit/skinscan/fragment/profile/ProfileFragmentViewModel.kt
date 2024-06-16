package com.bangkit.skinscan.fragment.profile

import androidx.lifecycle.ViewModel
import com.bangkit.skinscan.data.repository.Repository

class ProfileFragmentViewModel(private val repository: Repository): ViewModel() {
    suspend fun logout(){
        repository.logout()
    }
}