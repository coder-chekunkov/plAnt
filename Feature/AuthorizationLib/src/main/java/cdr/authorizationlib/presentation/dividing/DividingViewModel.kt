package cdr.authorizationlib.presentation.dividing

import androidx.lifecycle.ViewModel
import cdr.coreutilslib.logs.Logger

/**
 * [ViewModel] для разводящего экрана
 *
 * @author Alexandr Chekunkov
 */
internal class DividingViewModel : ViewModel() {


    /** Запуск экрана авторизации */
    fun launchAuthorizationScreen() {
        Logger.i(TAG, "--->>> launch authorization button clicked")
    }

    /** Запуск экрана регистрации */
    fun launchRegistrationScreen() {
        Logger.i(TAG, "--->>> launch registration button clicked")
    }

    companion object {
        private const val TAG = "DividingViewModel"
    }
}