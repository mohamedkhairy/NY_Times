package com.example.home.di


import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.data.remote.service.mostPopular.MostPopularServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(ViewModelComponent::class)
object ImageSearchServiceModule {

    @Provides
    fun provideImageSearchService(httpClient: HttpClient): MostPopularService {
        return MostPopularServiceImpl(httpClient)
    }

}