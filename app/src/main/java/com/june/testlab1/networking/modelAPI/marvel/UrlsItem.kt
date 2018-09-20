package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json

data class UrlsItem(

	@Json(name="type")
	val type: String? = null,

	@Json(name="url")
	val url: String? = null
)