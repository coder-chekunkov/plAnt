package cdr.plant.mapper

import cdr.plant.data.TestData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

/**
 * Реализация тестового маппера для получения данных
 *
 * @author Alexandr Chekunkov
 */
internal class TestDataMapperImpl (
    retrofit: Retrofit
): TestDataMapper {

    private val client = retrofit.create(TestDataApi::class.java)

    /** Запрос тестовых данных */
    override suspend fun getTestData(): TestData {
        return withContext(Dispatchers.IO) {
            return@withContext client.getMovieList().first()
        }
    }
}