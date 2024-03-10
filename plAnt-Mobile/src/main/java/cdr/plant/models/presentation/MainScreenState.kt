package cdr.plant.models.presentation

import cdr.plant.models.domain.TestData

/**
 * Стейт, который используется для главного экрана
 *
 * @author Alexandr Chekunkov
 */
internal sealed interface MainScreenState {

    /**
     * Успешно загруженные данные
     */
    @JvmInline
    value class Success(val data: TestData) : MainScreenState

    /**
     * Загрузка
     */
    object Loading : MainScreenState

    /**
     * Финальный экран
     */
    object EmptyScreen : MainScreenState
}
