package cdr.authorizationlib.models.presentation

import androidx.compose.ui.text.input.TextFieldValue
import cdr.corecompose.textfield.TextFieldCardStyles

internal sealed interface RegistrationState {

    /** Загрузка */
    object Loading : RegistrationState

    /**
     * Стандартное состояние экрана, с которым взаимодействует пользователь
     *
     * @property data UI-модель, содержащая в себе данные на экране
     */
    @JvmInline
    value class Screen(val data: RegistrationScreen = RegistrationScreen()) : RegistrationState
}

/**
 * UI-модель, содержащая в себе данные на экране
 *
 * @property login логин пользователя
 * @property firstPassword пароль пользователя
 * @property secondPassword пароль пользователя (используется для подтверждения корретности)
 * @property name имя пользователя
 * @property surname фамилия пользователя
 * @property isShowErrorAlert нужно ли показывать AlertDialog с ошибкой
 *
 * @author Alexandr Chekunkov
 */
internal data class RegistrationScreen(
    val login: RegistrationField = RegistrationField(),
    val firstPassword: RegistrationField = RegistrationField(),
    val secondPassword: RegistrationField = RegistrationField(),
    val name: RegistrationField = RegistrationField(),
    val surname: RegistrationField = RegistrationField(),
    val isShowErrorAlert: Boolean = false
)

/**
 * UI-модель, содержащая в себе данные поля ввода текста
 *
 * @property text текст поля ввода
 * @property subtitleVisibility видимость подзаголовка поля ввода
 * @property style стиль поля ввода
 *
 * @author Alexandr Chekunkov
 */
internal data class RegistrationField(
    val text: TextFieldValue = TextFieldValue(),
    val subtitleVisibility: Boolean = false,
    val style: TextFieldCardStyles = TextFieldCardStyles.Standard
)

/**
 * Экшены для экрана регистрации
 *
 * @author Alexandr Chekunkov
 */
internal sealed interface RegistrationAction {


    /** Отображение вспывающего окна с сообщением о незаполненных полях */
    object EmptyFields : RegistrationAction

    /** Отображение вспывающего окна с сообщением о разных паролях */
    object DifferentPasswords : RegistrationAction

    /** Отображение вспывающего окна с сообщением о коротком паролях */
    object TinyPassword : RegistrationAction
}