package com.example.home.data.mapper

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
                    id = article.assetId,
                    images = article.media.firstOrNull()?.let {it.mediaMetadata.lastOrNull()?.url},
                    publishedDate = article.publishedDate,
                    section = article.section,
                    source = article.source,
                    subsection = article.subsection,
                    title = article.title,
                    type = article.type,
                    url = article.url
                )
            }
        }

}
