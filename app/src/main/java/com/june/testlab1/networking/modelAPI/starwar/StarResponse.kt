package com.june.testlab1.networking.modelAPI.starwar


import com.squareup.moshi.Json


data class StarResponse(

	@Json(name="next")
	val next: String? = null,

	@Json(name="previous")
	val previous: Any? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="results")
	val results: List<ResultsItem?>? = null
)