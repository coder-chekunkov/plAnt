package cdr.authorizationlib.presentation.authorization

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cdr.authorizationlib.models.presentation.AuthorizationState
import cdr.corecompose.textfield.TextFieldCardStyles
import cdr.coreutilslib.logs.Logger
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * [ViewModel] для экрана авторизации
 *
 * @author Alexandr Chekunkov
 */
internal class AuthorizationViewModel : ViewModel() {

    /** Текущее состояние экрана */
    val state: StateFlow<AuthorizationState> get() = _state.asStateFlow()
    private val _state = MutableStateFlow<AuthorizationState>(AuthorizationState.Screen())

    /** Действие для показа snackbar на экране */
    val action: SharedFlow<Unit> get() = _action.asSharedFlow()
    private val _action = MutableSharedFlow<Unit>()

    /** Нажатие на кнопку навигации */
    fun launchPreviousScreen() {
        Logger.i(TAG, "--->>> back nav button clicked")
    }

    /** Нажатие на кнопку "Продолжить" на экране */
    fun signIn() {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState is AuthorizationState.Screen) {
                val currentData = currentState.data

                val blankLogin = currentData.login.text.isBlank()
                val blankPassword = currentData.password.text.isBlank()

                if (blankLogin || blankPassword) {
                    _state.value = AuthorizationState.Screen(
                        data = currentData.copy(
                            loginStyle = if (blankLogin) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard,
                            passwordStyle = if (blankPassword) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                        )
                    )
                    _action.emit(Unit)
                } else {
                    _state.value = AuthorizationState.Loading

                    // TODO: логика обращения к удаленному сервису с авторизацией
                    delay(1350) // удалить после выполнения задачи

                    _state.value = AuthorizationState.Screen(
                        data = currentData.copy(isShowErrorAlert = true)
                    )
                }
            }
        }
    }

    /** Обработка нового логина с UI */
    fun handleNewLogin(newLogin: TextFieldValue) {
        val currentState = _state.value
        if (currentState is AuthorizationState.Screen) {
            val currentData = currentState.data

            _state.value = AuthorizationState.Screen(
                data = currentData.copy(
                    login = if (newLogin.text.length <= MAX_CHARACTERS) newLogin else currentData.login,
                    loginSubtitleVisibility = newLogin.text.length >= MAX_CHARACTERS,
                    loginStyle = TextFieldCardStyles.Standard
                )
            )
        }
    }

    /** Обработка нового пароля с UI */
    fun handleNewPassword(newPassword: TextFieldValue) {
        val currentState = _state.value
        if (currentState is AuthorizationState.Screen) {
            val currentData = currentState.data
            _state.value = AuthorizationState.Screen(
                data = currentData.copy(
                    password = if (newPassword.text.length <= MAX_CHARACTERS) newPassword else currentData.password,
                    passwordSubtitleVisibility = newPassword.text.length >= MAX_CHARACTERS,
                    passwordStyle = TextFieldCardStyles.Standard
                )
            )
        }
    }

    /** Сокрытие AlertDialog с UI */
    fun dismissAlertDialog() {
        val currentState = _state.value
        if (currentState is AuthorizationState.Screen) {
            val currentData = currentState.data
            _state.value = AuthorizationState.Screen(
                data = currentData.copy(
                    isShowErrorAlert = false
                )
            )
        }
    }

    companion object {
        private const val TAG = "AuthorizationViewModel"
        private const val MAX_CHARACTERS = 64
    }
}