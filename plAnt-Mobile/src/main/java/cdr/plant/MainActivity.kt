package cdr.plant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cdr.corecompose.alert.AlertDialog
import cdr.corecompose.alert.AlertDialogData
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle
import cdr.corecompose.progressbar.ProgressBarCircle
import cdr.corecompose.text.Body1Secondary
import cdr.corecompose.text.Headline3
import cdr.corecompose.text.Title2Warning
import cdr.corecompose.theming.PlAntTheme
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor
import cdr.plant.models.domain.TestData
import cdr.plant.models.presentation.MainScreenState

/**
 * Тестовый экран
 *
 * @author Alexandr Chekunkov
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()

        setContent {
            PlAntTheme {
                MainContent(viewModel)
            }
        }
    }
}

@Composable
private fun MainContent(viewModel: MainViewModel) {
    val state by viewModel.data.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) { viewModel.fetchData() }

    when (val currentState = state) {
        is MainScreenState.Success -> SuccessfulContent(viewModel, currentState.data)
        MainScreenState.Loading -> LoadingShimmer()
        MainScreenState.EmptyScreen -> EmptyScreen(viewModel)
    }
}

@Composable
private fun SuccessfulContent(
    viewModel: MainViewModel,
    data: TestData
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PlAntTokens.Background1.getThemedColor())
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Headline3(
                text = data.name,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Body1Secondary(text = "Команда создателей: ${data.team}")
            Body1Secondary(text = "Дата создания: ${data.createdby}")
            Body1Secondary(text = "Ссылка на постер: ${data.imageurl}")
        }

        Box(
            modifier = Modifier.background(PlAntTokens.Background1.getThemedColor())
        ) {
            Blueberry(
                text = "Получить следующий вопрос",
                style = BlueberryStyle.Standard,
                onClick = { viewModel.getQuestion() })
        }
    }
}

@Composable
private fun EmptyScreen(viewModel: MainViewModel) {
    var isShowAlert by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PlAntTokens.Background1.getThemedColor())
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title2Warning(
                text = "Список закончился",
                textAlign = TextAlign.Center
            )

            Body1Secondary(
                text = "Для продолжения работы - загрузите новые данные",
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier.background(PlAntTokens.Background1.getThemedColor())
        ) {
            Blueberry(
                text = "Информация",
                style = BlueberryStyle.Negative,
                onClick = { isShowAlert = true })
        }
    }

    if (isShowAlert) {
        AlertDialog(
            data = AlertDialogData(
                title = "Нет данных",
                subtitle = "Загрузите новые данные",
                image = cdr.coreresourceslib.R.drawable.illustration_256_empty,
                firstButtonText = "Загрузить",
                properties = DialogProperties(dismissOnClickOutside = false)
            ),
            onDismissClick = { isShowAlert = false },
            onFirstButtonClick = { viewModel.fetchData() }
        )
    }
}

@Composable
private fun LoadingShimmer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PlAntTokens.Background1.getThemedColor()),
        contentAlignment = Alignment.Center
    ) {
        ProgressBarCircle(text = "Загрузка тестовых данных")
    }
}