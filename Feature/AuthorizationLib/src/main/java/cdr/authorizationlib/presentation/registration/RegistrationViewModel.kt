package cdr.authorizationlib.presentation.registration

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cdr.authorizationlib.models.presentation.RegistrationAction
import cdr.authorizationlib.models.presentation.RegistrationScreen
import cdr.authorizationlib.models.presentation.RegistrationState
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
 * [ViewModel] для экрана регистрации
 *
 * @author Alexandr Chekunkov
 */
internal class RegistrationViewModel : ViewModel() {

    /** Текущее состояние экрана */
    val state: StateFlow<RegistrationState> get() = _state.asStateFlow()
    private val _state = MutableStateFlow<RegistrationState>(RegistrationState.Screen())

    /** Действие для показа snackbar на экране */
    val action: SharedFlow<RegistrationAction> get() = _action.asSharedFlow()
    private val _action = MutableSharedFlow<RegistrationAction>()

    /** Нажатие на кнопку навигации */
    fun launchPreviousScreen() {
        Logger.i(TAG, "--->>> back nav button clicked")
    }

    /** Нажатие на кнопку "Продолжить" на экране */
    fun signUp() {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState is RegistrationState.Screen) {
                val currentData = currentState.data

                if (checkIsNotBlank(currentData)) {
                    if (checkIsSamePasswords(currentData)) {
                        if (checkIsNotTinyPassword(currentData)) {
                            if (checkIsNotEasyPassword(currentData)) {
                                _state.value = RegistrationState.Loading

                                // TODO: логика обращения к удаленному сервису с авторизацией
                                delay(1350) // удалить после выполнения задачи

                                _state.value = RegistrationState.Screen(data = currentData.copy(isShowErrorAlert = true))
                            }
                        }
                    }
                }
            }
        }
    }

    /** Проверка на пустые поля */
    private suspend fun checkIsNotBlank(currentData: RegistrationScreen): Boolean {
        val blankLogin = currentData.login.text.text.isBlank()
        val blankFirstPassword = currentData.firstPassword.text.text.isBlank()
        val blankSecondPassword = currentData.secondPassword.text.text.isBlank()
        val blankName = currentData.name.text.text.isBlank()
        val blankSurname = currentData.surname.text.text.isBlank()

        return if (blankLogin || blankFirstPassword || blankSecondPassword || blankName || blankSurname) {
            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    login = currentData.login.copy(
                        style = if (blankLogin) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                    ),
                    firstPassword = currentData.firstPassword.copy(
                        style = if (blankFirstPassword) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                    ),
                    secondPassword = currentData.secondPassword.copy(
                        style = if (blankSecondPassword) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                    ),
                    name = currentData.name.copy(
                        style = if (blankName) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                    ),
                    surname = currentData.surname.copy(
                        style = if (blankSurname) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard
                    ),
                )
            )
            _action.emit(RegistrationAction.EmptyFields)

            false
        } else true
    }

    /** Проверка на равность введенных паролей */
    private suspend fun checkIsSamePasswords(currentData: RegistrationScreen): Boolean =
        if (currentData.firstPassword.text.text != currentData.secondPassword.text.text) {
            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    firstPassword = currentData.firstPassword.copy(style = TextFieldCardStyles.Warning),
                    secondPassword = currentData.secondPassword.copy(style = TextFieldCardStyles.Warning)
                )
            )
            _action.emit(RegistrationAction.DifferentPasswords)

            false
        } else true

    /** Проверка на длину пароля */
    private suspend fun checkIsNotTinyPassword(currentData: RegistrationScreen) : Boolean =
        if (currentData.firstPassword.text.text.length < MIN_PASSWORD_SIZE) {
            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    firstPassword = currentData.firstPassword.copy(style = TextFieldCardStyles.Warning),
                    secondPassword = currentData.secondPassword.copy(style = TextFieldCardStyles.Warning)
                )
            )
            _action.emit(RegistrationAction.TinyPassword)

            false
        } else true

    /** Проверка на сложность пароля */
    private suspend fun checkIsNotEasyPassword(currentData: RegistrationScreen): Boolean =
        true

    /** Обработка нового логина с UI */
    fun handleNewLogin(newLogin: TextFieldValue) {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data

            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    login = currentData.login.copy(
                        text = if (newLogin.text.length <= MAX_CHARACTERS) newLogin else currentData.login.text,
                        subtitleVisibility = newLogin.text.length >= MAX_CHARACTERS,
                        style = TextFieldCardStyles.Standard
                    )
                )
            )
        }
    }

    /** Обработка нового пароля с UI (первый пароль) */
    fun handleFirstPassword(newPassword: TextFieldValue) {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data

            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    firstPassword = currentData.firstPassword.copy(
                        text = if (newPassword.text.length <= MAX_CHARACTERS) newPassword else currentData.firstPassword.text,
                        subtitleVisibility = newPassword.text.length >= MAX_CHARACTERS,
                        style = TextFieldCardStyles.Standard
                    )
                )
            )
        }
    }

    /** Обработка нового пароля с UI (второй пароль) */
    fun handleSecondPassword(newPassword: TextFieldValue) {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data

            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    secondPassword = currentData.secondPassword.copy(
                        text = if (newPassword.text.length <= MAX_CHARACTERS) newPassword else currentData.secondPassword.text,
                        subtitleVisibility = newPassword.text.length >= MAX_CHARACTERS,
                        style = TextFieldCardStyles.Standard
                    )
                )
            )
        }
    }

    /** Обработка нового пароля с UI (второй пароль) */
    fun handleName(newName: TextFieldValue) {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data

            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    name = currentData.name.copy(
                        text = if (newName.text.length <= MAX_CHARACTERS) newName else currentData.name.text,
                        subtitleVisibility = newName.text.length >= MAX_CHARACTERS,
                        style = TextFieldCardStyles.Standard
                    )
                )
            )
        }
    }

    /** Обработка нового пароля с UI (второй пароль) */
    fun handleSurname(newSurname: TextFieldValue) {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data

            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    surname = currentData.surname.copy(
                        text = if (newSurname.text.length <= MAX_CHARACTERS) newSurname else currentData.surname.text,
                        subtitleVisibility = newSurname.text.length >= MAX_CHARACTERS,
                        style = TextFieldCardStyles.Standard
                    )
                )
            )
        }
    }


    /** Сокрытие AlertDialog с UI */
    fun dismissAlertDialog() {
        val currentState = _state.value
        if (currentState is RegistrationState.Screen) {
            val currentData = currentState.data
            _state.value = RegistrationState.Screen(
                data = currentData.copy(
                    isShowErrorAlert = false
                )
            )
        }
    }

    companion object {
        private const val TAG = "RegistrationViewModel"
        private const val MAX_CHARACTERS = 64
        private const val MIN_PASSWORD_SIZE = 8
    }
}