package cdr.plant.domain.repository

import cdr.plant.domain.mapper.TestDataMapper
import cdr.plant.models.data.TestDataRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Реализация [TestDataRepository]
 *
 * @param testDataMapper Маппер для получения тестовых данных
 *
 * @author Alexandr Chekunkov
 */
internal class TestDataRepositoryImpl(
    private val testDataMapper: TestDataMapper
) : TestDataRepository {

    override suspend fun getTestData(): List<TestDataRequest> =
        withContext(Dispatchers.IO) {
            return@withContext testDataMapper.getTestData()
        }

}