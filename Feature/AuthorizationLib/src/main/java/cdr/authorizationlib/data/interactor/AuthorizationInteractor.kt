package cdr.authorizationlib.data.interactor

/**
 * Интерактор для модуля авторизации
 *
 * @author Alexandr Chekunkov
 */
internal interface AuthorizationInteractor {

    /** Авторизация пользователя */
    suspend fun signIn()

    /** Регистрация нового пользователя */
    suspend fun signUp()
}