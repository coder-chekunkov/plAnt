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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
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
import cdr.corecompose.text.Body3Secondary
import cdr.corecompose.text.Headline3
import cdr.corecompose.text.Title2
import cdr.corecompose.textfield.TextFieldCard
import cdr.corecompose.textfield.TextFieldCardStyles
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

    var login by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var loginSubtitleVisibility by remember { mutableStateOf(false) }
    var passwordSubtitleVisibility by remember { mutableStateOf(false) }
    var loginWarningStyle by remember { mutableStateOf(false) }
    var passwordWarningStyle by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PlAntTokens.Background1.getThemedColor())
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Bottom
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 54.dp, horizontal = 16.dp)
                .background(PlAntTokens.Background1.getThemedColor())
                .weight(1f)
        ) {
            Title2(
                text = "Введите логин и пароль",
                modifier = Modifier.fillMaxWidth()
            )
            Body3Secondary(
                text = "Для авторизации введите данные учетной записи",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            TextFieldCard(
                style = if (loginWarningStyle) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard,
                text = login,
                label = "Логин",
                onTextChange = { newText ->
                    loginWarningStyle = false
                    loginSubtitleVisibility = if (newText.text.length < 100) {
                        login = newText
                        false
                    } else {
                        true
                    }
                },
                subtitleVisibility = loginSubtitleVisibility,
                subtitleText = "Вы ввели максимальное количество символов"
            )

            TextFieldCard(
                style = if (passwordWarningStyle) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard,
                text = password,
                label = "Пароль",
                onTextChange = { newText ->
                    passwordSubtitleVisibility = if (newText.text.length < 100) {
                        password = newText
                        false
                    } else {
                        true
                    }
                    passwordWarningStyle = false
                },
                subtitleVisibility = passwordSubtitleVisibility,
                subtitleText = "Вы ввели максимальное количество символов",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        Blueberry(
            text = "Продолжить",
            style = BlueberryStyle.Standard,
            onClick = {
                when {
                    login.text.isBlank() && password.text.isBlank() -> {
                        loginWarningStyle = true
                        passwordWarningStyle = true
                    }
                    login.text.isBlank() -> loginWarningStyle = true
                    password.text.isBlank() -> passwordWarningStyle = true
                    else -> isShowAlert = true
                }
            }
        )
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