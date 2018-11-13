package com.june.testlab1.networking.modelAPI.setprice


import com.squareup.moshi.Json


data class SetPriceRequest(

	@Json(name="ServerId")
	val serverId: String? = null,

	@Json(name="CreatedBy")
	val createdBy: String? = null,

	@Json(name="BranchID")
	val branchID: String? = null
)