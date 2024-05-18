package com.example.home.data.mapper


import com.example.home.fakeData.MostPopularValid
import com.example.home.serializeArticleData
import com.example.sharedData.model.Article
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArticlesMapperTest {

    private lateinit var articlesMapper: ArticlesMapper

    @Before
    fun setUp() {
        articlesMapper = ArticlesMapper()
    }

    @Test
    fun `articlesMapper maps response to article model correctly`() {
        // setup
        val articleResponse = serializeArticleData(MostPopularValid.data)

        // execute
        val article = articlesMapper.map(articleResponse)

        // Assert
        assertEquals(articleResponse.articleResponses?.firstOrNull()?.id, article?.firstOrNull()?.id)
        assertEquals(articleResponse.articleResponses?.firstOrNull()?.publishedDate, article?.firstOrNull()?.publishedDate)
    }

    @Test
    fun `articlesMapper maps empty result response to article model`() {
        // setup
        val articleResponse = serializeArticleData(MostPopularValid.emptyArticleResult)

        // execute
        val article = articlesMapper.map(articleResponse)

        // Assert
        assertEquals(emptyList<Article>(), article)
    }

}