package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class Res(

	@Json(name="status")
	val status: Status? = null
)