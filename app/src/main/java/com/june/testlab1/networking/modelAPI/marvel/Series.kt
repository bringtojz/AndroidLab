package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json

data class Series(

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null
)