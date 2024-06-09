package com.bangkit.skinscan.data.di

import android.content.Context
import com.bangkit.skinscan.data.preference.UserPreference
import com.bangkit.skinscan.data.preference.dataStore
import com.bangkit.skinscan.data.remote.ApiConfig
import com.bangkit.skinscan.data.repository.Repository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository {
        val preferences = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { preferences.getSession().first() }
        val apiService = ApiConfig.getApiService()
        return Repository.getInstance(apiService, preferences)
    }
}