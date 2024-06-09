package com.bangkit.skinscan.data.remote.user.response

import com.google.gson.annotations.SerializedName


data class RegisterResponse(
	@field:SerializedName("message")
	val message: String
)
