package com.bangkit.skinscan.data.remote.request

data class RegisterRequest(
    val displayName: String,
    val email: String,
    val password: String
)
