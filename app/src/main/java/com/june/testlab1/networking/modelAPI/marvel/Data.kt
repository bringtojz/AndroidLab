package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json


data class Data(

	@Json(name="total")
	val total: Int? = null,

	@Json(name="offset")
	val offset: Int? = null,

	@Json(name="limit")
	val limit: Int? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
)