package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NYTimesMostPopularResponse(
    @SerialName("copyright")
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int,
    @SerialName("results")
    val articles: List<Article>?,
    @SerialName("status")
    val status: String
)