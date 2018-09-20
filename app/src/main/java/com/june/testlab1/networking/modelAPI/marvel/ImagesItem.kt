package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json

data class ImagesItem(

	@Json(name="path")
	val path: String? = null,

	@Json(name="extension")
	val extension: String? = null
)