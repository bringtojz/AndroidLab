package com.june.testlab1.networking.modelAPI.setprice


import com.squareup.moshi.Json


data class BranchItem(

	@Json(name="PriceMap")
	val priceMap: String? = null,

	@Json(name="SV")
	val sV: String? = null,

	@Json(name="Size")
	val size: String? = null,

	@Json(name="region_id")
	val regionId: String? = null,

	@Json(name="BranchID")
	val branchID: String? = null,

	@Json(name="price_zone")
	val priceZone: String? = null,

	@Json(name="PackageType")
	val packageType: String? = null,

	@Json(name="effective_date")
	val effectiveDate: String? = null,

	@Json(name="BranchName")
	val branchName: String? = null,

	@Json(name="SendPost")
	val SendPost : String? = null,

	@Json(name="ReceiverPost")
	val ReceiverPost : String? = null,

	@Json(name="route_code")
	val routeCode: String? = null,

	@Json(name="SizeID")
	val sizeID: String? = null,

	@Json(name="Route")
	val route: String? = null
)