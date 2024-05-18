package com.example.home.domain.repository

import com.example.sharedData.model.Article

interface MostPopularRepository {
    suspend fun callMostPopular(period: String): List<Article>?

}