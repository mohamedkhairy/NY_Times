package com.example.home.data.remote.service.mostPopular

import com.example.home.data.remote.dto.NYTimesMostPopularResponse

interface MostPopularService {

    suspend fun callMostPopular(period: String): NYTimesMostPopularResponse?


}
