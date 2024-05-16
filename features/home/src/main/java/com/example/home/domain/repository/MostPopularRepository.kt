package com.example.home.domain.repository

import com.example.sharedData.model.Article
import java.time.Period

interface MostPopularRepository {
    suspend fun callMostPopular(period: String): List<Article>?

}