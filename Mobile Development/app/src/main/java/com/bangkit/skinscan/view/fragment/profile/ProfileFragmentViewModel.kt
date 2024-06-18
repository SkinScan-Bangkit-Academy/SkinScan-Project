package com.bangkit.skinscan.view.fragment.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.skinscan.data.repository.Repository

class ProfileFragmentViewModel(private val repository: Repository): ViewModel() {
    val userSession = repository.getSession().asLiveData()
    suspend fun logout(){
        repository.logout()
    }
}