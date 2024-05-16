package com.example.network.di

import com.example.nytimes.core.network.BuildConfig
import io.ktor.http.URLBuilder
import io.ktor.http.appendPathSegments
import io.ktor.http.path
import io.ktor.http.set

object Endpoints {

//    http://api.nytimes.com/svc/
    //    mostpopular/v2/viewed/{period}.json?
    //    api-key=sample-key


    const val BASE_URL = BuildConfig.BASE_URL
    const val DSF = "mostpopular/v2/viewed/"

    fun MOST_POPULAR_API(period: String) =
        URLBuilder(BASE_URL).apply {
            appendPathSegments(DSF).
            appendPathSegments("$period.json")
            parameters.append("api-key", BuildConfig.API_KEY)
        }.build()

}