package com.bangkit.skinscan.data.remote.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("status")
	val status: String
)

data class DataItem(

	@field:SerializedName("article")
	val article: Article
)

data class Article(

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("date")
	val date: String
)
