package com.bangkit.skinscan.view.main.diseasehome

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityDetailItemHomeBinding

class DetailItemHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailItemHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailItemHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}