package com.bangkit.skinscan.view.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bangkit.skinscan.R
import com.bangkit.skinscan.data.remote.user.request.RegisterRequest
import com.bangkit.skinscan.databinding.ActivityRegisterBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.login.LoginActivity
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel by viewModels<RegisterViewModel> { ViewModelFactory.getInstance(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterBinding.inflate(layoutInflater)
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
        binding.goToLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRegister()
    }

    private fun btnRegister() {
        binding.btnLogin.setOnClickListener {
            showLoading(true)
            val name = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPw.text.toString().trim()

            if (name.isEmpty()){
                binding.etUsername.error = "Data tidak boleh kosong"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                binding.etEmail.error = "Data tidak boleh kosong"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.etPw.error = "Data tidak boleh kosong"
                return@setOnClickListener
            }

            val request = RegisterRequest(email, password)
            lifecycleScope.launch {
                try {
                    showLoading(false)
                    val response = registerViewModel.register(request)
                    showToast("Akun berhasil dibuat")
                    Log.d(TAG, "btnRegister: ${response.message}")

                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: HttpException) {
                    showLoading(false)
                    Log.d(TAG, "btnRegister: ${e.message}")
                    showToast("Gagal membuat akun. Coba lagi!")
                } catch (e: Exception) {
                    showLoading(false)
                    Log.d(TAG, "btnRegister: ${e.message}")
                    showToast("Gagal membuat akun. Coba lagi!")
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun showLoading(isLoading: Boolean) {
    binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val TAG = "RegisterActivity"
    }
}