package com.example.home.data.repository


import com.example.home.data.mapper.ArticlesMapper
import com.example.home.data.remote.service.mostPopular.MostPopularService
import com.example.home.domain.enums.Periods
import com.example.home.domain.repository.MostPopularRepository
import com.example.home.engine.MostPopularServiceFake
import com.example.home.engine.ServiceResponseType
import com.example.home.fakeData.MostPopularValid.getNYTimesArticles
import com.example.sharedData.model.Article
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MostPopularRepositoryTest {


    private val expectedResultSize = 5
    private val emptyResultSize = 0
    private val validResult = getNYTimesArticles()

    private lateinit var repository: MostPopularRepository
    private lateinit var service: MostPopularService
    private lateinit var mapper: ArticlesMapper

    @Before
    fun setUp() {
        mapper = ArticlesMapper()
    }

    @Test
    fun `MostPopularArticles fetches data from API and maps to Article successfully`() = runBlocking {
        // Setup
        service = MostPopularServiceFake.build(
            type = ServiceResponseType.GoodData
        )
        repository = MostPopularRepositoryImp(service, mapper)


        // Execute
        val result = repository.callMostPopular(Periods.LAST_WEEK.name)

        // Assert
        assertEquals(expectedResultSize, result?.size)
        assertEquals(validResult.articleResponses?.first()?.id, result?.firstOrNull()?.id)

    }

    @Test
    fun `MostPopularArticles fetches empty data from API and maps to Article`() = runBlocking {
        // Setup
        service = MostPopularServiceFake.build(
            type = ServiceResponseType.EmptyResultList
        )
        repository = MostPopularRepositoryImp(service, mapper)


        // Execute
        val result = repository.callMostPopular(Periods.LAST_WEEK.name)

        // Assert
        assertEquals(emptyResultSize, result?.size)
        assertEquals(emptyList<Article>(), result)

    }
}