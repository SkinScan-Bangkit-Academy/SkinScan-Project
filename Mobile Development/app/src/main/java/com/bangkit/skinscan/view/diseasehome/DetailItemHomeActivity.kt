package com.bangkit.skinscan.view.diseasehome

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.skinscan.R
import com.bangkit.skinscan.data.Disease
import com.bangkit.skinscan.databinding.ActivityDetailItemHomeBinding

class DetailItemHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailItemHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailItemHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent.getParcelableExtra<Disease>(EXTRA_USER) as Disease
        setDetail(intent)
    }

    private fun setDetail(details: Disease){
        with(binding){
            imgView.setImageResource(details.img)
            diagnosingTitle.text = getString(details.name)
            drugRecTv.text = getString(details.about)
        }
    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}