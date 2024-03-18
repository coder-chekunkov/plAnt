package cdr.authorizationlib.models.presentation

import androidx.compose.ui.text.input.TextFieldValue
import cdr.corecompose.textfield.TextFieldCardStyles

/**
 * Состояние экрана авторизации
 *
 * @author Alexandr Chekunkov
 */
internal sealed interface AuthorizationState {

    /** Загрузка */
    object Loading : AuthorizationState

    /**
     * Стандартное состояние экрана, с которым взаимодействует пользователь
     *
     * @property data UI-модель, содержащая в себе данные на экране
     */
    @JvmInline
    value class Screen(val data: AuthorizationScreen = AuthorizationScreen()) : AuthorizationState
}

/**
 * UI-модель, содержащая в себе данные на экране
 *
 * @property login логин пользователя
 * @property loginSubtitleVisibility видимость подзагловка у поля ввода логина
 * @property loginStyle стиль поля ввода логина
 * @property password пароль пользователя
 * @property passwordSubtitleVisibility видимость подзагловка у поля ввода пароля
 * @property passwordStyle стиль поля ввода пароля
 * @property isShowErrorAlert нужно ли показывать AlertDialog с ошибкой
 *
 * @author Alexandr Chekunkov
 */
internal data class AuthorizationScreen(
    val login: TextFieldValue = TextFieldValue(),
    val loginSubtitleVisibility: Boolean = false,
    val loginStyle: TextFieldCardStyles = TextFieldCardStyles.Standard,
    val password: TextFieldValue = TextFieldValue(),
    val passwordSubtitleVisibility: Boolean = false,
    val passwordStyle: TextFieldCardStyles = TextFieldCardStyles.Standard,
    val isShowErrorAlert: Boolean = false
)