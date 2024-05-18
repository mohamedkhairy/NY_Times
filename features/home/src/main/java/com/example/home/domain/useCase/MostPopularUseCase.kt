package com.example.home.domain.useCase

import android.util.Log
import com.example.home.domain.repository.MostPopularRepository
import com.example.sharedData.model.Article
import com.example.utils.core.toJsonString
import com.example.utils.usecases.FlowUseCase
import com.paymob.pos.utils.dispatchers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MostPopularUseCase @Inject constructor(
    private val mostPopularRepository: MostPopularRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FlowUseCase<String, List<Article>?>(ioDispatcher) {

    override suspend fun execute(parameters: String): Flow<List<Article>?> = flow {
        emit(mostPopularRepository.callMostPopular(parameters))
    }

}

