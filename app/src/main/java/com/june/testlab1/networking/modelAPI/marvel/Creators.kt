package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json


data class Creators(

	@Json(name="collectionURI")
	val collectionURI: String? = null,

	@Json(name="available")
	val available: Int? = null,

	@Json(name="returned")
	val returned: Int? = null,

	@Json(name="items")
	val items: List<ItemsItem?>? = null
)