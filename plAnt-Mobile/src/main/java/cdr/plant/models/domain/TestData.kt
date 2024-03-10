package cdr.plant.models.domain


/**
 * Тестовые данные
 *
 * @property name название
 * @property team команда создателей
 * @property createdby дата создания
 * @property imageurl ссылка на изображение
 *
 * @author Alexandr Chekunkov
 */
internal data class TestData(
    val name: String,
    val team: String,
    val createdby: String,
    val imageurl: String
)
