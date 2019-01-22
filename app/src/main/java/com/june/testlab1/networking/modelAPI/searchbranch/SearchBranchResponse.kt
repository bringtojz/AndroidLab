package com.june.testlab1.networking.modelAPI.searchbranch


import com.squareup.moshi.Json


data class SearchBranchResponse(

	@Json(name="status_code")
	val statusCode: String? = null,

	@Json(name="status_desc")
	val statusDesc: String? = null,

	@Json(name="Branch")
	val branch: List<BranchItem?>? = null
)