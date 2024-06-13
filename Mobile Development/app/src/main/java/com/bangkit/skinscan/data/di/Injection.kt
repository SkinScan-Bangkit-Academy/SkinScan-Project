package com.bangkit.skinscan.data.di

import android.content.Context
import com.bangkit.skinscan.data.preference.UserPreference
import com.bangkit.skinscan.data.preference.dataStore
import com.bangkit.skinscan.data.remote.ApiConfig
import com.bangkit.skinscan.data.repository.Repository
object Injection {
    fun provideRepository(context: Context): Repository {
        val preferences = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService, preferences)
    }
}