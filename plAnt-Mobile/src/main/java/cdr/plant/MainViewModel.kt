package cdr.plant

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cdr.coreutilslib.network.BaseRestClientImpl
import cdr.coreutilslib.logs.Logger
import cdr.plant.domain.interactor.TestDataInteractorImpl
import cdr.plant.domain.mapper.TestDataMapperImpl
import cdr.plant.domain.repository.TestDataRepositoryImpl
import cdr.plant.models.domain.TestData
import cdr.plant.models.presentation.MainScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel для главного экрана
 *
 * @author Alexandr Chekunkov
 */
internal class MainViewModel : ViewModel() {

    val data: StateFlow<MainScreenState>  get() = _data.asStateFlow()
    private val _data = MutableStateFlow<MainScreenState>(MainScreenState.EmptyScreen)

    private var currentNumber = 0
    private var testDataList = listOf<TestData>()

    private val baseRestClient = BaseRestClientImpl()
    private val testDataMapper = TestDataMapperImpl(baseRestClient.baseRestClient())
    private val testDataRepository = TestDataRepositoryImpl(testDataMapper)
    private val testDataInteractor = TestDataInteractorImpl(testDataRepository)

    fun fetchData() {
        viewModelScope.launch {
            _data.value = MainScreenState.Loading
            testDataList = testDataInteractor.getTestData()
            currentNumber = 0

            delay(1500) // Задержка 3 сек.
            getQuestion()
            Logger.d("MainViewModel", "test data was fetched")
        }
    }

    fun getQuestion() {
        _data.value = if (currentNumber < testDataList.size) {
            MainScreenState.Success(testDataList[currentNumber])
        } else {
            MainScreenState.EmptyScreen
        }
        currentNumber += 1
    }
}