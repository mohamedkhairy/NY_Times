package com.example.home.data.remote.service.mostPopular

import com.example.home.domain.enums.Periods
import com.example.home.engine.MostPopularServiceFake
import com.example.home.engine.ServiceResponseType
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MostPopularServiceTest {

    private val expectedResultNum = 5
    private val invalidRequestPeriods = "11"

    @Test
    fun `test most popular service with success response`() =  runBlocking {
        // setup
        val mostPopularService = MostPopularServiceFake.build(
            type = ServiceResponseType.GoodData // good data
        )

        // execute
        val response = mostPopularService.callMostPopular(Periods.LAST_WEEK.name)

        // verify
        Assert.assertEquals(expectedResultNum, response?.numResults)
    }

    @Test
    fun `test most popular service with bad request`() {
        Assert.assertThrows(NoTransformationFoundException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val mostPopularService = MostPopularServiceFake.build(
                    type = ServiceResponseType.InvalidData
                )

                // execute
                mostPopularService.callMostPopular(invalidRequestPeriods)
            }
        }
    }
    @Test
    fun `test most popular service with invalid response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val mostPopularService = MostPopularServiceFake.build(
                    type = ServiceResponseType.InvalidData
                )

                // execute
                mostPopularService.callMostPopular(Periods.LAST_WEEK.name)
            }
        }
    }



    @Test
    fun `test most popular service with not found response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val mostPopularService = MostPopularServiceFake.build(
                    type = ServiceResponseType.Http404
                )

                // execute
                mostPopularService.callMostPopular(Periods.LAST_WEEK.name)
            }
        }
    }

    @Test
    fun `test most popular service with Empty response`() {
        Assert.assertThrows(JsonConvertException::class.java) {
            runBlocking {
                // Code that should throw an exception

                // setup
                val mostPopularService = MostPopularServiceFake.build(
                    type = ServiceResponseType.EmptyResponse
                )

                // execute
                mostPopularService.callMostPopular(Periods.LAST_WEEK.name)
            }
        }
    }
}