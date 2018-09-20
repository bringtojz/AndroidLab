package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json

data class TextObjectsItem(

	@Json(name="language")
	val language: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="type")
	val type: String? = null
)