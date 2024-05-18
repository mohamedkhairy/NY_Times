package com.example.home.engine

import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.data.remote.service.mostPopular.MostPopularServiceImpl
import com.example.home.domain.enums.Periods
import com.example.home.fakeData.MostPopularEmpty
import com.example.home.fakeData.MostPopularInvalid
import com.example.home.fakeData.MostPopularValid
import com.example.network.di.Endpoints
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.engine.mock.respondError
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.http.Url
import io.ktor.http.fullPath
import io.ktor.http.headersOf
import io.ktor.http.hostWithPort
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MostPopularServiceFake {

    companion object Factory {

        private val Url.hostWithPortIfRequired: String get() = if (port == protocol.defaultPort) host else hostWithPort
        private val Url.fullUrl: String get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"

        fun build(
            type: ServiceResponseType
        ): MostPopularService {
            val client = HttpClient(MockEngine) {
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
                engine {
                    addHandler { request ->
                        when (request.url.fullUrl) {
                            Endpoints.MOST_POPULAR_API(Periods.LAST_WEEK.name).fullUrl -> {
                                val responseHeaders = headersOf(
                                    "Content-Type" to listOf("application/json", "charset=utf-8")
                                )
                                when(type){
                                    is ServiceResponseType.EmptyResponse -> {
                                        respond(
                                            MostPopularEmpty.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.EmptyResultList -> {
                                        respond(
                                            MostPopularValid.emptyArticleResult,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.InvalidData -> {
                                        respond(
                                            MostPopularInvalid.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.GoodData -> {
                                        respond(
                                            MostPopularValid.data,
                                            status = HttpStatusCode.OK,
                                            headers = responseHeaders
                                        )
                                    }
                                    is ServiceResponseType.Http404 -> {
                                        respondError(
                                            status = HttpStatusCode.NotFound,
                                            headers = responseHeaders
                                        )
                                    }
                                }
                            }
                            else -> respondBadRequest()
                        }
                    }
                }
            }
            return MostPopularServiceImpl(client)
        }
    }
}