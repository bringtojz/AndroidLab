package com.june.testlab1.networking.modelAPI.addpostcode


import com.squareup.moshi.Json


data class AddPostCodeRequest(

	@Json(name="ServerId")
	val serverId: String? = null,

	@Json(name="CreatedBy")
	val createdBy: String? = null,

	@Json(name="postalcode")
	val postalcode: String? = null,

	@Json(name="BranchID")
	val branchID: String? = null
)