package cdr.plant.domain.mapper

import cdr.plant.models.data.TestDataRequest

/**
 * Маппер для получения тестовых данных
 *
 * @author Alexandr Chekunkov
 */
internal interface TestDataMapper {

    suspend fun getTestData(): List<TestDataRequest>

}