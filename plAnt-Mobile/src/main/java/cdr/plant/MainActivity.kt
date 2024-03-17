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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cdr.corecompose.alert.AlertDialog
import cdr.corecompose.alert.AlertDialogData
import cdr.corecompose.appbar.AppBar
import cdr.corecompose.appbar.AppBarNavigationButtons
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle
import cdr.corecompose.progressbar.ProgressBarCircle
import cdr.corecompose.snackbar.SnackbarCard
import cdr.corecompose.snackbar.SnackbarCardData
import cdr.corecompose.snackbar.showSnackbarCard
import cdr.corecompose.text.Body1Secondary
import cdr.corecompose.text.Body3Secondary
import cdr.corecompose.text.Title2
import cdr.corecompose.textfield.TextFieldCard
import cdr.corecompose.textfield.TextFieldCardStyles
import cdr.corecompose.theming.PlAntTheme
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.getThemedColor
import cdr.coreutilslib.utils.viewModelCreator
import cdr.plant.models.domain.TestData
import cdr.plant.models.presentation.MainScreenState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Тестовый экран
 *
 * @author Alexandr Chekunkov
 */
class MainActivity : ComponentActivity() {

    private val viewModel by viewModelCreator<MainViewModel> { MainViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
    Scaffold(
        modifier = Modifier
            .background(PlAntTokens.Background0.getThemedColor())
            .padding(horizontal = 16.dp),
        topBar = {
            AppBar(
                title = data.name,
                backgroundColor = PlAntTokens.Background1.getThemedColor(),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(PlAntTokens.Background0.getThemedColor())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PlAntTokens.Background0.getThemedColor())
                    .weight(1f),
            ) {
                Body1Secondary(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Команда создателей: ${data.team}"
                )
                Body1Secondary(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Дата создания: ${data.createdby}"
                )
                Body1Secondary(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "Ссылка на постер: ${data.imageurl}"
                )
            }

            Blueberry(
                text = "Получить следующий вопрос",
                style = BlueberryStyle.Standard,
                onClick = { viewModel.getQuestion() },
                horizontalPadding = 0.dp
            )

        }
    }
}

@Composable
private fun EmptyScreen(viewModel: MainViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    var isShowAlert by remember { mutableStateOf(false) }

    var login by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var loginSubtitleVisibility by remember { mutableStateOf(false) }
    var passwordSubtitleVisibility by remember { mutableStateOf(false) }
    var loginWarningStyle by remember { mutableStateOf(false) }
    var passwordWarningStyle by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .background(PlAntTokens.Background0.getThemedColor())
            .padding(horizontal = 16.dp),
        topBar = {
            AppBar(
                backgroundColor = PlAntTokens.Background0.getThemedColor(),
                navigationButton = AppBarNavigationButtons.Back,
                navigationButtonTint = PlAntTokens.Primary.getThemedColor()
            )
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { snackbarData ->
                SnackbarCard(
                    snackbarData = snackbarData,
                    data = SnackbarCardData(
                        icon = cdr.coreresourceslib.R.drawable.ic_warning,
                        iconTint = PlAntTokens.Warning.getThemedColor(),
                        closeIcon = true
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(PlAntTokens.Background0.getThemedColor())
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PlAntTokens.Background0.getThemedColor())
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

            Column {
                TextFieldCard(
                    style = if (loginWarningStyle) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard,
                    text = login,
                    label = "Логин",
                    onTextChange = { newText ->
                        loginSubtitleVisibility = newText.text.length >= 15
                        if (newText.text.length <= 15) login = newText
                        loginWarningStyle = false
                    },
                    subtitleVisibility = loginSubtitleVisibility,
                    subtitleText = stringResource(id = cdr.coreresourceslib.R.string.entered_max_number_of_characters)
                )

                TextFieldCard(
                    style = if (passwordWarningStyle) TextFieldCardStyles.Warning else TextFieldCardStyles.Standard,
                    text = password,
                    label = "Пароль",
                    onTextChange = { newText ->
                        passwordSubtitleVisibility = newText.text.length >= 15
                        if (newText.text.length <= 15) password = newText
                        passwordWarningStyle = false
                    },
                    subtitleVisibility = passwordSubtitleVisibility,
                    subtitleText = stringResource(id = cdr.coreresourceslib.R.string.entered_max_number_of_characters),
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
                            showSnackbarCard(snackbarHostState, coroutineScope)
                        }

                        login.text.isBlank() -> {
                            loginWarningStyle = true
                            showSnackbarCard(snackbarHostState, coroutineScope)
                        }
                        password.text.isBlank() -> {
                            passwordWarningStyle = true
                            showSnackbarCard(snackbarHostState, coroutineScope)
                        }
                        else -> isShowAlert = true
                    }
                },
                horizontalPadding = 0.dp
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
}

/**
 * Функция запуска [SnackbarCard].
 *
 * @param snackbarHostState хост для вспывающего окна
 * @param coroutineScope скоуп-короутин
 *
 * @author Alexandr Chekunkov
 */
fun showSnackbarCard(
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope
) {
    coroutineScope.launch {
        snackbarHostState.showSnackbarCard("Заполните пункты выше, чтобы продолжить")
    }
}

@Composable
private fun LoadingShimmer() {
    Scaffold(
        modifier = Modifier
            .background(PlAntTokens.Background0.getThemedColor())
            .padding(horizontal = 16.dp),
        topBar = {
            AppBar(backgroundColor = PlAntTokens.Background0.getThemedColor())
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(PlAntTokens.Background0.getThemedColor()),
            contentAlignment = Alignment.Center
        ) {
            ProgressBarCircle(text = "Загрузка тестовых данных")
        }
    }
}