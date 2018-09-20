package com.june.testlab1.networking.modelAPI.marvel

import com.squareup.moshi.Json

data class DatesItem(

	@Json(name="date")
	val date: String? = null,

	@Json(name="type")
	val type: String? = null
)