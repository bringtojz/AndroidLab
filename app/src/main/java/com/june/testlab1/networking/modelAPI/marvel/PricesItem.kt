package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json


data class PricesItem(

	@Json(name="price")
	val price: Double? = null,

	@Json(name="type")
	val type: String? = null
)