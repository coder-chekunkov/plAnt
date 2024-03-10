package cdr.plant.domain.repository

import cdr.plant.models.data.TestDataRequest

/**
 * Репозиторий для получения тестовых данных
 *
 * @author Alexandr Chekunkov
 */
internal interface TestDataRepository {

    suspend fun getTestData(): List<TestDataRequest>
}