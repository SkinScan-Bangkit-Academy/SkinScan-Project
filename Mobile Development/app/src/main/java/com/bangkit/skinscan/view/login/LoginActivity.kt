package com.bangkit.skinscan.view.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bangkit.skinscan.R
import com.bangkit.skinscan.data.preference.UserModel
import com.bangkit.skinscan.databinding.ActivityLoginBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.main.MainActivity
import com.bangkit.skinscan.view.register.RegisterActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> { ViewModelFactory.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showLoading(false)
        setView()
    }

    private fun setView(){
        binding.goToSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        btnLogin()
    }

    private fun btnLogin() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPw.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = getString(R.string.invalid_data)
                return@setOnClickListener
            }
            if (pass.isEmpty()) {
                binding.etPw.error = getString(R.string.invalid_data)
                return@setOnClickListener
            }

            binding.etEmail.error = null
            binding.etPw.error = null

            loginViewModel.login(email, pass)
            loginViewModel.isLoading.observe(this) {
                showLoading(it)
            }

            loginViewModel.loginResult.observe(this) { result ->
                // Login successful, save session
                showToast(getString(R.string.login_success))
                lifecycleScope.launch {
                    saveSession(
                        UserModel(
                            result.userCredential.tokenResponse.idToken,
                            result.userCredential.user.email,
                            result.userCredential.tokenResponse.displayName,
                            true
                        )
                    )
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private suspend fun saveSession(session: UserModel) {
        loginViewModel.saveSession(session)
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        ViewModelFactory.clearInstance()
        startActivity(intent)
        finish()
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}