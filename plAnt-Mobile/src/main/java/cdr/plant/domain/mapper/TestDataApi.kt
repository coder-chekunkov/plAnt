package cdr.plant.domain.mapper

import cdr.plant.models.data.TestDataRequest
import retrofit2.http.GET

/**
 * API-интерфейс для получения тестовых данных
 *
 * @author Alexandr Chekunkov
 */
internal interface TestDataApi {

    @GET("marvel")
    suspend fun getMovieList(): List<TestDataRequest>
}