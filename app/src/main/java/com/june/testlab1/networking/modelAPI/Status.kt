package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class Status(

	@Json(name="status_code")
	val statusCode: String? = null,

	@Json(name="status_desc")
	val statusDesc: String? = null
)