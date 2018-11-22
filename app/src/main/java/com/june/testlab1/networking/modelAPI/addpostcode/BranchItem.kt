package com.june.testlab1.networking.modelAPI.addpostcode


import com.squareup.moshi.Json


data class BranchItem(

	@Json(name="province")
	val province: String? = null,

	@Json(name="postalcode")
	val postalcode: String? = null,

	@Json(name="district")
	val district: String? = null,

	@Json(name="effective_date")
	val effectiveDate: String? = null,

	@Json(name="region_id")
	val regionId: String? = null,

	@Json(name="remark")
	val remark: String? = null,

	@Json(name="amphur")
	val amphur: String? = null,

	@Json(name="postalcode_id")
	val postalcodeId: String? = null
)