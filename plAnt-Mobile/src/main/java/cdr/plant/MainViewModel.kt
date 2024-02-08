package cdr.plant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cdr.coreserver.BaseRestClientImpl
import cdr.plant.mapper.TestDataMapperImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val data: StateFlow<String> get() = _data.asStateFlow()
    private val _data = MutableStateFlow("")

    private val baseRestClient = BaseRestClientImpl()
    private val testDataMapper = TestDataMapperImpl(
        baseRestClient.baseRestClient()
    )

    fun fetchData() {
        viewModelScope.launch {
            val testData = testDataMapper.getTestData()

            _data.value = testData.toString()
        }
    }
}