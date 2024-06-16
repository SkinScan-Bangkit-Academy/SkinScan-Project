package com.bangkit.skinscan.data.remote.response

import com.google.gson.annotations.SerializedName


data class RegisterResponse(
	@field:SerializedName("message")
	val message: String
)
