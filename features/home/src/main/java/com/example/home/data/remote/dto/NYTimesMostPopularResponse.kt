package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NYTimesMostPopularResponse(
    @SerialName("copyright")
    val copyright: String?,
    @SerialName("num_results")
    val numResults: Int?,
    @SerialName("results")
    val articleResponses: List<ArticleResponse>?,
    @SerialName("status")
    val status: String?
)