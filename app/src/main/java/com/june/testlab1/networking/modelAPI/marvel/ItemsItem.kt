package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json

data class ItemsItem(

	@Json(name="name")
	val name: String? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="type")
	val type: String? = null
)