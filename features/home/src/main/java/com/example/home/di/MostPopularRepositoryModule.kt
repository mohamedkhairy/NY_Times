package com.example.home.di

import com.example.home.data.mapper.ArticlesMapper
import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.data.repository.MostPopularRepositoryImp
import com.example.home.domain.repository.MostPopularRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MostPopularRepositoryModule {

    @Provides
    fun provideMostPopularRepository(
        service: MostPopularService,
        entityDomainMapper: ArticlesMapper,
    ): MostPopularRepository =
        MostPopularRepositoryImp(service, entityDomainMapper)

}
