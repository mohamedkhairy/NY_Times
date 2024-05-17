package com.example.home.data.mapper

import com.example.home.data.remote.dto.Media
import com.example.home.data.remote.dto.NYTimesMostPopularResponse
import com.example.sharedData.model.Article
import com.example.utils.mapper.BaseMapper
import javax.inject.Inject


class ArticlesMapper @Inject constructor() :
    BaseMapper<NYTimesMostPopularResponse?, List<Article>?> {
    override fun map(model: NYTimesMostPopularResponse?): List<Article>? =
        model?.let {
            it.articleResponses?.map { article ->
                Article(
                    abstract = article.abstract,
//                    adxKeywords = article.adxKeywords,
//                    assetId = article.assetId,
//                    byline = article.byline,
//                    desFacet = article.desFacet,
//                    etaId = article.etaId,
//                    geoFacet = article.geoFacet,
                    id = article.assetId,
                    images = article.media.firstOrNull()?.let {it.mediaMetadata.lastOrNull()?.url},
//                    nytdsection = article.nytdsection,
//                    orgFacet = article.orgFacet,
//                    perFacet = article.perFacet,
                    publishedDate = article.publishedDate,
                    section = article.section,
                    source = article.source,
                    subsection = article.subsection,
                    title = article.title,
                    type = article.type,
//                    updated = article.updated,
//                    uri = article.uri,
                    url = article.url
                )
            }
        }

}
