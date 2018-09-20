package com.june.testlab1.networking.modelAPI.marvel


import com.squareup.moshi.Json


data class ResultsItem(

	@Json(name="creators")
	val creators: Creators? = null,

	@Json(name="issueNumber")
	val issueNumber: Int? = null,

	@Json(name="isbn")
	val isbn: String? = null,

	@Json(name="description")
	val description: Any? = null,

	@Json(name="variants")
	val variants: List<VariantsItem?>? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="diamondCode")
	val diamondCode: String? = null,

	@Json(name="characters")
	val characters: Characters? = null,

	@Json(name="urls")
	val urls: List<UrlsItem?>? = null,

	@Json(name="ean")
	val ean: String? = null,

	@Json(name="collections")
	val collections: List<Any?>? = null,

	@Json(name="modified")
	val modified: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="prices")
	val prices: List<PricesItem?>? = null,

	@Json(name="events")
	val events: Events? = null,

	@Json(name="collectedIssues")
	val collectedIssues: List<Any?>? = null,

	@Json(name="pageCount")
	val pageCount: Int? = null,

	@Json(name="thumbnail")
	val thumbnail: Thumbnail? = null,

	@Json(name="images")
	val images: List<Any?>? = null,

	@Json(name="stories")
	val stories: Stories? = null,

	@Json(name="textObjects")
	val textObjects: List<Any?>? = null,

	@Json(name="digitalId")
	val digitalId: Int? = null,

	@Json(name="format")
	val format: String? = null,

	@Json(name="upc")
	val upc: String? = null,

	@Json(name="dates")
	val dates: List<DatesItem?>? = null,

	@Json(name="resourceURI")
	val resourceURI: String? = null,

	@Json(name="variantDescription")
	val variantDescription: String? = null,

	@Json(name="issn")
	val issn: String? = null,

	@Json(name="series")
	val series: Series? = null
)