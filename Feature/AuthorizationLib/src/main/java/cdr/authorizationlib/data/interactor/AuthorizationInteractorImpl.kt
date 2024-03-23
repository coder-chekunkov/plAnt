package cdr.authorizationlib.data.interactor

import kotlinx.coroutines.delay

/**
 * Реализация [AuthorizationInteractor]
 *
 * @author Alexandr Chekunkov
 */
internal class AuthorizationInteractorImpl : AuthorizationInteractor {
    override suspend fun signIn() {
        delay(1350) // удалить после выполнения задачи
        throw UnknownError("Нет доступа к удаленному сервису")
    }

    override suspend fun signUp() {
        delay(1350) // удалить после выполнения задачи
        throw UnknownError("Нет доступа к удаленному сервису")
    }
}