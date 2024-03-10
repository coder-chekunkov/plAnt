package cdr.plant.domain.interactor

import cdr.plant.domain.converter.convert
import cdr.plant.domain.repository.TestDataRepository
import cdr.plant.models.domain.TestData

/**
 * Реализация [MainScreenInteractor]
 *
 * @author Alexandr Chekunkov
 */
internal class TestDataInteractorImpl(
    private val testDataRepository: TestDataRepository
) : MainScreenInteractor {

    override suspend fun getTestData(): List<TestData> = testDataRepository.getTestData().map {
        testDataRequest -> testDataRequest.convert()
    }
}