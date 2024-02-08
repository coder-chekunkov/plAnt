package cdr.plant.mapper

import cdr.plant.data.TestData

internal interface TestDataMapper {

    suspend fun getTestData(): TestData

}