package com.june.testlab1.networking.modelAPI.getposprice


import com.squareup.moshi.Json


data class GetPosPriceRequest(

	@Json(name="BranchID")
	val branchID: String? = null
)