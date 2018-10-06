package com.june.testlab1.networking.modelAPI


import com.squareup.moshi.Json


data class BranchItem(

		@Json(name="operating_datetime")
		val operatingDatetime: String? = null,

		@Json(name="first_open_date")
		val firstOpenDate: String? = null,

		@Json(name="NameAddress")
		val nameAddress: String? = null,

		@Json(name="BranchID")
		val branchID: String? = null,

		@Json(name="taxInvoiceNo_From_Server")
		val taxInvoiceNoFromServer: String? = null,

		@Json(name="tax_CompanyName")
		val taxCompanyName: String? = null,

		@Json(name="tax_Telephone")
		val taxTelephone: String? = null,

		@Json(name="branch_type")
		val branchType: String? = null,

		@Json(name="tax_PostalCode")
		val taxPostalCode: String? = null,

		@Json(name="tax_branch_name")
		val taxBranchName: String? = null,

		@Json(name="tax_TaxID")
		val taxTaxID: String? = null,

		@Json(name="BranchName")
		val branchName: String? = null,

		@Json(name="tax_Address2")
		val taxAddress2: String? = null,

		@Json(name="tax_Address1")
		val taxAddress1: String? = null
)