package cdr.plant.mapper

import cdr.plant.data.TestData
import retrofit2.http.GET

/**
 * API-интерфейс для получения тестовых данных
 *
 * @author Alexandr Chekunkov
 */
internal interface TestDataApi {

    @GET("marvel")
    suspend fun getMovieList(): List<TestData>
}