package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class BranchReq(

	@Json(name="BranchID")
	val branchID: String? = null
)