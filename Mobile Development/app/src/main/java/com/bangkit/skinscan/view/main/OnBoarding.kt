package com.bangkit.skinscan.view.main

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityOnBoardingBinding
import com.ncorti.slidetoact.SlideToActView

class OnBoarding : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var sequentialAnimator: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playAnimation()

        val slideToActView = findViewById<SlideToActView>(R.id.slideToAct)
        slideToActView.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener {
            override fun onSlideComplete(view: SlideToActView) {
                val intent = Intent(this@OnBoarding, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun playAnimation() {
        val line1 =
            ObjectAnimator.ofFloat(binding.onboardingword1, View.ALPHA, 1f).setDuration(1000)
        val line2 =
            ObjectAnimator.ofFloat(binding.onboardingword2, View.ALPHA, 1f).setDuration(1000)
        val line3 =
            ObjectAnimator.ofFloat(binding.onboardingword3, View.ALPHA, 1f).setDuration(1000)
        val line4 =
            ObjectAnimator.ofFloat(binding.onboardingword4, View.ALPHA, 1f).setDuration(1000)
        val line5 =
            ObjectAnimator.ofFloat(binding.onboardingword5, View.ALPHA, 1f).setDuration(1000)

        val together = AnimatorSet().apply {
            playTogether(line3, line4)
        }

        sequentialAnimator = AnimatorSet().apply {
            playSequentially(line1, line2, together, line5)
            start()
        }

    }


}

