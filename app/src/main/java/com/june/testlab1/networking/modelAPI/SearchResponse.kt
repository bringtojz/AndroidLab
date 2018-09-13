package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class SearchResponse(

	@Json(name="status_code")
	val statusCode: String? = null,

	@Json(name="status_desc")
	val statusDesc: String? = null,

	@Json(name="Branch")
	val branch: List<BranchItem?>? = null
)