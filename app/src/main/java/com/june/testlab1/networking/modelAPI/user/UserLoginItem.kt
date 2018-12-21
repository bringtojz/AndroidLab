package com.june.testlab1.networking.modelAPI.user


import com.squareup.moshi.Json


data class UserLoginItem(

	@Json(name="UserName")
	val userName: String? = null,

	@Json(name="UserId")
	val userId: String? = null,

	@Json(name="Password")
	val password: String? = null
)