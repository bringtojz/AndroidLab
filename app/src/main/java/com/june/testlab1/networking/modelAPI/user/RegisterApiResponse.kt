package com.june.testlab1.networking.modelAPI.user


import com.squareup.moshi.Json


data class RegisterApiResponse(

	@Json(name="status_code")
	val statusCode: String? = null,

	@Json(name="status_desc")
	val statusDesc: String? = null,

	@Json(name="UserLogin")
	val userLogin: List<UserLoginItem?>? = null
)