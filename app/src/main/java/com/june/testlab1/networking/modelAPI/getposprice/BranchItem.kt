package com.june.testlab1.networking.modelAPI.getposprice


import com.squareup.moshi.Json

data class BranchItem(

	@Json(name="BKK")
	val bKK: String? = null,

	@Json(name="Pass")
	val pass: String? = null,

	@Json(name="PackageType")
	val packageType: String? = null,

	@Json(name="UPC")
	val uPC: String? = null,

	@Json(name="BranchID")
	val branchID: String? = null,

	@Json(name="SizeDesc")
	val sizeDesc: String? = null
)