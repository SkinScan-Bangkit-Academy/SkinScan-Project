package com.bangkit.skinscan.view

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.skinscan.data.di.Injection
import com.bangkit.skinscan.data.repository.Repository
import com.bangkit.skinscan.view.login.LoginViewModel
import com.bangkit.skinscan.view.splash.SplashViewModel
import com.bangkit.skinscan.view.register.RegisterViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> RegisterViewModel(repository)
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository)
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(repository)
            else -> throw IllegalArgumentException("unknown ViewModel: ${modelClass.name}")
        }
        @Suppress("UNCHECKED_CAST")
        return viewModel as T
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun clearInstance(){
            Repository.clearInstance()
            INSTANCE = null
        }

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}