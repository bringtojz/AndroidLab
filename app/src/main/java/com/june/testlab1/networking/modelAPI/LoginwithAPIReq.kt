package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class LoginwithAPIReq(

	@Json(name="password")
	val password: String? = null,

	@Json(name="username")
	val username: String? = null
)