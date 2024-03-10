package cdr.plant.domain.converter

import cdr.plant.models.data.TestDataRequest
import cdr.plant.models.domain.TestData

/**
 * Получить [TestData] из [TestDataRequest]
 *
 * @author Alexandr Chekunkov
 */
internal fun TestDataRequest.convert(): TestData = TestData(
    name = this.name ?: "",
    team = this.team ?: "",
    createdby = this.createdby ?: "",
    imageurl = this.imageurl ?: ""
)