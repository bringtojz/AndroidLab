package com.june.testlab1.networking.modelAPI.starwar


import com.squareup.moshi.Json


data class LoginRequest(

	@Json(name="password")
	val password: String? = null,

	@Json(name="username")
	val username: String? = null
)