package com.example.home.domain.useCase

import com.example.home.data.mapper.ArticlesMapper
import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.data.repository.MostPopularRepositoryImp
import com.example.home.domain.enums.Periods
import com.example.home.domain.repository.MostPopularRepository
import com.example.home.engine.MostPopularServiceFake
import com.example.home.engine.ServiceResponseType
import com.example.home.fakeData.MostPopularValid
import com.example.sharedData.model.Article
import com.example.utils.core.UiState
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MostPopularUseCaseTest {


    private val exceptionMessage =
        "Unexpected JSON token at offset 0: Expected start of the object '{', but had 'N' instead at path: \$\n" +
                "JSON input: Not Found"

    private lateinit var repository: MostPopularRepository
    private lateinit var service: MostPopularService
    private lateinit var mapper: ArticlesMapper
    private lateinit var useCase: MostPopularUseCase


    @Before
    fun setUp() {
        mapper = ArticlesMapper()
    }

    @Test
    fun `test MostPopularUseCase with success data`() =
        runBlocking {
            // Setup
            service = MostPopularServiceFake.build(
                type = ServiceResponseType.GoodData
            )
            repository = MostPopularRepositoryImp(service, mapper)
            useCase = MostPopularUseCase(repository, Dispatchers.IO)

            // Execute
            val result = useCase(Periods.LAST_WEEK.name).toList()

            println(result.size)
            // Assert
            Assert.assertEquals(UiState.Loading<List<Article>>(true), result.first())
            Assert.assertEquals(UiState.Success(MostPopularValid.getArticlesList()), result[1])
        }


    @Test
    fun `test MostPopularUseCase with failure`() =
        runBlocking {
        // Setup
        service = MostPopularServiceFake.build(
            type = ServiceResponseType.Http404
        )
        repository = MostPopularRepositoryImp(service, mapper)
        useCase = MostPopularUseCase(repository, Dispatchers.IO)

        // Execute
        val result = useCase(Periods.LAST_WEEK.name).toList()
        val error = result[1] as UiState.Error
        val errorMessage = error.throwable?.message

        // Assert
        Assert.assertEquals(result.first(), UiState.Loading<List<Article>>(true))
        Assert.assertEquals(exceptionMessage, errorMessage)

    }
}