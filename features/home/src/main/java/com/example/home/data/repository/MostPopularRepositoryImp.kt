package com.example.home.data.repository

import com.example.home.data.mapper.ArticlesMapper
import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.domain.repository.MostPopularRepository
import com.example.sharedData.model.Article
import javax.inject.Inject

class MostPopularRepositoryImp @Inject constructor(
    private val service: MostPopularService,
    private val articlesMapper: ArticlesMapper,
    ) : MostPopularRepository {

    override suspend fun callMostPopular(period: String): List<Article>? =
        service.callMostPopular(period)?.let(
            articlesMapper::map
        )


}