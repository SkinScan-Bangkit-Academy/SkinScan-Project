package com.bangkit.skinscan.view.fragment.profile.resetpass

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityResetPassBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.login.LoginActivity
import kotlinx.coroutines.launch

class ResetPassActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPassBinding
    private val resetPassViewModel by viewModels<ResetPassViewModel> { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showLoading(false)

        resetPassViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        resetPassViewModel.resetResult.observe(this) {
            it?.let {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.title_dialog_reset_password))
                    .setMessage(getString(R.string.message_dialog_reset))
                    .setPositiveButton(getString(R.string.ok)){ dialog, which ->
                        navigateToLogin()
                    }.show()
                Log.d(TAG, "btnReset: ${it.message}")
            }
        }

        btnReset()
    }

    private fun btnReset() {
        binding.btnReset.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.pass.text.toString().trim()

            if (email.isEmpty()) {
                binding.email.error = getString(R.string.invalid_data)
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.pass.error = getString(R.string.invalid_data)
                return@setOnClickListener
            }

            binding.email.error = null
            binding.pass.error = null

            resetPassViewModel.resetPass(email)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun navigateToLogin() {
        lifecycleScope.launch {
            resetPassViewModel.logout()
            val intent = Intent(this@ResetPassActivity, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }
    }

    companion object {
        const val TAG = "ResetPassActivity"
    }
}
