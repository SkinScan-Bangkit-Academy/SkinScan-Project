package com.bangkit.skinscan.view.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.data.repository.Repository

class SplashViewModel(private val repository: Repository): ViewModel() {
    suspend fun logout(){
        repository.logout()
    }

    fun getSession(): LiveData<UserModel>{
        return repository.getSession().asLiveData()
    }
}