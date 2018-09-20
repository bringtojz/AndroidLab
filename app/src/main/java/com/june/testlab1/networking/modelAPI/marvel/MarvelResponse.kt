package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json


data class MarvelResponse(

	@Json(name="copyright")
	val copyright: String? = null,

	@Json(name="code")
	val code: Int? = null,

	@Json(name="data")
	val data: Data? = null,

	@Json(name="attributionHTML")
	val attributionHTML: String? = null,

	@Json(name="attributionText")
	val attributionText: String? = null,

	@Json(name="etag")
	val etag: String? = null,

	@Json(name="status")
	val status: String? = null
)