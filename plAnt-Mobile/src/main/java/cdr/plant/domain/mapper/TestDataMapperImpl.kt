package cdr.plant.domain.mapper

import cdr.plant.models.data.TestDataRequest
import retrofit2.Retrofit

/**
 * Реализация тестового маппера для получения данных
 *
 * @author Alexandr Chekunkov
 */
internal class TestDataMapperImpl(
    retrofit: Retrofit
) : TestDataMapper {

    private val client = retrofit.create(TestDataApi::class.java)

    /** Запрос тестовых данных */
    override suspend fun getTestData(): List<TestDataRequest> = client.getMovieList()

}