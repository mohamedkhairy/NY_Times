package com.example.home.data.remote.service.mostPopular

import android.util.Log
import com.example.home.data.remote.dto.NYTimesMostPopularResponse
import com.example.network.di.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

class MostPopularServiceImpl @Inject constructor(val httpClient: HttpClient) : MostPopularService {

    override suspend fun callMostPopular(period: String): NYTimesMostPopularResponse {
//        return httpClient.get<NYTimesMostPopularResponse>(Endpoints.MOST_POPULAR_API()) {
//            parameter("period", period)
//        }
        val result = httpClient.get(Endpoints.MOST_POPULAR_API(period)) {
//            parameter("period", period)
        }.body<NYTimesMostPopularResponse>()

        return result
    }


}