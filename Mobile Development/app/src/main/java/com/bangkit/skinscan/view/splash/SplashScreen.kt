package com.bangkit.skinscan.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinscan.R
import com.bangkit.skinscan.view.onboarding.OnBoarding

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT :Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent( this, OnBoarding::class.java))
            finish()
        }, SPLASH_TIME_OUT)

    }
}