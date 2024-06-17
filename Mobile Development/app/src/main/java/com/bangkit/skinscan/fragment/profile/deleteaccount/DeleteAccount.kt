package com.bangkit.skinscan.fragment.profile.deleteaccount

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.ActivityDeleteAccountBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.login.LoginActivity
import kotlinx.coroutines.launch

class DeleteAccount : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteAccountBinding
    private val deleteAccountViewModel by viewModels<DeleteAccountViewModel> { ViewModelFactory.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeleteAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showLoading(false)

        deleteAccountViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        deleteAccountViewModel.deleteResult.observe(this) {
            it?.let {
                showToast("Your account has been deleted successfully")
                Log.d(TAG, "btnDelete: ${it.message}")
                navigateToLogin()
            }
        }

        btnDelete()
    }

    private fun btnDelete() {
        binding.btnDelete.setOnClickListener {
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

            deleteAccountViewModel.deleteAccount(email)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun navigateToLogin() {
        lifecycleScope.launch {
            deleteAccountViewModel.logout()
            val intent = Intent(this@DeleteAccount, LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }
    }

    companion object {
        const val TAG = "DeleteAccountActivity"
    }
}
