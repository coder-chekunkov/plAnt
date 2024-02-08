package cdr.coreserver

import retrofit2.Retrofit

/**
 * Базовый клиент для сетевого взаимодействия
 *
 * @author Alexandr Chekunkov
 */
interface BaseRestClient {

    fun baseRestClient(): Retrofit
}