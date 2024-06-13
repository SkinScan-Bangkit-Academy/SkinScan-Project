package com.bangkit.skinscan.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinscan.R
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.main.MainActivity
import com.bangkit.skinscan.view.onboarding.OnBoarding

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT :Long = 3000
    private val splashViewModel by viewModels<SplashViewModel> { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            splashViewModel.getSession().observe(this){ user ->
                if (!user.isLogin){
                    startActivity(Intent( this, OnBoarding::class.java))
                    finish()
                } else {
                    val intent = Intent(this@SplashScreen, MainActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                    finish()
                }
            }
        }, SPLASH_TIME_OUT)
    }
}