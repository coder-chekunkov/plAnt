package cdr.corenavigation

import androidx.lifecycle.ViewModel
import cdr.corelogs.Logger

/**
 * Базовая ViewModel, которая используется во всех функциональных пакетах системы
 * Реализовывает [ViewModel]
 *
 * @author Alexandr Chekunkov
 */
class CoreBaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        Logger.i(tag = TAG, message = "${javaClass.name} was onCleared.")
    }

    companion object {
        private const val TAG = "CoreBaseViewModel"
    }
}