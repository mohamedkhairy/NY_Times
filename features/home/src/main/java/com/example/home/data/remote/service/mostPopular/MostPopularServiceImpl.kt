package com.example.home.data.remote.service.mostPopular

import com.example.home.data.remote.dto.ImageResultResponse
import com.example.home.data.remote.dto.NYTimesMostPopularResponse
import com.example.network.di.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class MostPopularServiceImpl @Inject constructor(val httpClient: HttpClient) : MostPopularService {

    override suspend fun callMostPopular(period: String): NYTimesMostPopularResponse {
        return httpClient.get<NYTimesMostPopularResponse>(Endpoints.MOST_POPULAR_API()) {
            parameter("period", period)
        }
    }


}