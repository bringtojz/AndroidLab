package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class LoginResponse(

	@Json(name="res")
	val res: Res? = null
)