package com.example.sharedData.model


data class Article(
    val abstract: String,
    val id: Long,
    val images: String?,
    val publishedDate: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val url: String
)