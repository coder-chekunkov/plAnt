package cdr.plant.domain.interactor

import cdr.plant.models.domain.TestData

/**
 * Интерактор, который используется на главном экране
 *
 * @author Alexandr Chekunkov
 */
internal interface MainScreenInteractor {

    suspend fun getTestData(): List<TestData>
}