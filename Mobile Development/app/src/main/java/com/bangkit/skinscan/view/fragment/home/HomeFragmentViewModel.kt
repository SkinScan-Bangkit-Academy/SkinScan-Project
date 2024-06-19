package com.bangkit.skinscan.view.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bangkit.skinscan.data.repository.Repository

class HomeFragmentViewModel(private val repository: Repository): ViewModel() {
    val userSession = repository.getSession().asLiveData()
}