package com.june.testlab1.networking.modelAPI.checkprice


import com.squareup.moshi.Json


data class CheckPriceReq(

	@Json(name="PostalCode")
	val postalCode: String? = null,

	@Json(name="BranchID")
	val branchID: String? = null
)