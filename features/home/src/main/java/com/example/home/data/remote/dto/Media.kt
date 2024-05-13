package com.example.home.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Media(
    @SerialName("approved_for_syndication")
    val approvedForSyndication: Int,
    @SerialName("caption")
    val caption: String,
    @SerialName("copyright")
    val copyright: String,
    @SerialName("media-metadata")
    val mediaMetadata: List<MediaMetadata>,
    @SerialName("subtype")
    val subtype: String,
    @SerialName("type")
    val type: String
)