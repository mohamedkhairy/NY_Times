package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    @SerialName("abstract")
    val abstract: String,
    @SerialName("adx_keywords")
    val adxKeywords: String,
    @SerialName("asset_id")
    val assetId: Long,
    @SerialName("byline")
    val byline: String,
    @SerialName("column")
    val column: String?,
    @SerialName("des_facet")
    val desFacet: List<String>,
    @SerialName("eta_id")
    val etaId: Int,
    @SerialName("geo_facet")
    val geoFacet: List<String>,
    @SerialName("id")
    val id: Long,
    @SerialName("media")
    val media: List<Media>,
    @SerialName("nytdsection")
    val nytdsection: String,
    @SerialName("org_facet")
    val orgFacet: List<String>,
    @SerialName("per_facet")
    val perFacet: List<String>,
    @SerialName("published_date")
    val publishedDate: String,
    @SerialName("section")
    val section: String,
    @SerialName("source")
    val source: String,
    @SerialName("subsection")
    val subsection: String,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("updated")
    val updated: String,
    @SerialName("uri")
    val uri: String,
    @SerialName("url")
    val url: String
)