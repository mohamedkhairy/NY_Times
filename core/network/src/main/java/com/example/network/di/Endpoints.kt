package com.example.network.di

import com.example.pixabayimages.core.network.BuildConfig
import io.ktor.http.URLBuilder

object Endpoints {

//    http://api.nytimes.com/svc/
    //    mostpopular/v2/viewed/{period}.json?
    //    api-key=sample-key


    const val BASE_URL = BuildConfig.BASE_URL

    fun MOST_POPULAR_API() =
        URLBuilder(BASE_URL).apply {
            parameters.append("api-key", BuildConfig.API_KEY)
        }.build()

}