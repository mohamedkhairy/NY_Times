package com.example.sharedData.model


data class Article(
    val abstract: String,
    val adxKeywords: String,
    val assetId: Long,
    val byline: String,
    val desFacet: List<String>,
    val etaId: Int,
    val geoFacet: List<String>,
    val id: Long,
    val images: List<String>?,
    val nytdsection: String,
    val orgFacet: List<String>,
    val perFacet: List<String>,
    val publishedDate: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
)