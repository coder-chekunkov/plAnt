package cdr.authorizationlib.models.presentation

/**
 * Экшены для разделительного экрана
 *
 * @author Alexandr Chekunkov
 */
internal sealed interface DividingAction {

    /** Запуск экрана авторизации */
    object LaunchAuthorizationScreen : DividingAction

    /** Запуск экрана регистрации */
    object LaunchRegistrationScreen : DividingAction
}