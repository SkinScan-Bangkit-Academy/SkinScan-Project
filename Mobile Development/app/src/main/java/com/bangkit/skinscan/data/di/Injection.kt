package com.bangkit.skinscan.data.di

import android.content.Context
import com.bangkit.skinscan.data.remote.ApiConfig
import com.bangkit.skinscan.data.remote.Repository

object Injection {
    fun provideRepository(context: Context): Repository {
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService)
    }
}