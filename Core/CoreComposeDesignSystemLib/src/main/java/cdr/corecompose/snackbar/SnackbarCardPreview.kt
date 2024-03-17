package cdr.corecompose.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.appbar.AppBar
import cdr.corecompose.buttons.blueberry.Blueberry
import cdr.corecompose.buttons.blueberry.BlueberryStyle
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor
import kotlinx.coroutines.launch
import cdr.coreresourceslib.R

/**
 * Превью для Snackbar (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun SnackbarCardLightThemePreview() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    PreviewPlantTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .background(PlAntTokens.Background1.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background1.getThemedColor(),
                    title = "SnackbarLightThemePreview"
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) { snackBarData ->
                    SnackbarCard(
                        snackbarData = snackBarData,
                        data = SnackbarCardData(
                            icon = R.drawable.ic_warning,
                            iconTint = PlAntTokens.Warning.getThemedColor(),
                            closeIcon = true,
                        )
                    )
                }
            }

        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PlAntTokens.Background1.getThemedColor())
                    .padding(paddingValues)
            ) {
                Blueberry(
                    text = "Показать Snackbar",
                    style = BlueberryStyle.Standard,
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbarCard(
                                message = "Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить"
                            )
                        }
                    },
                    horizontalPadding = 0.dp
                )
            }
        }
    }
}

/**
 * Превью для Snackbar (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun SnackbarCardDarkThemePreview() {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    PreviewPlantTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier
                .background(PlAntTokens.Background1.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background1.getThemedColor(),
                    title = "SnackbarLightThemePreview"
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState) { snackBarData ->
                    SnackbarCard(
                        snackbarData = snackBarData,
                        data = SnackbarCardData(
                            icon = R.drawable.ic_warning,
                            iconTint = PlAntTokens.Warning.getThemedColor(),
                            closeIcon = false
                        )
                    )
                }
            }

        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(PlAntTokens.Background1.getThemedColor())
                    .padding(paddingValues)
            ) {
                Blueberry(
                    text = "Показать Snackbar",
                    style = BlueberryStyle.Standard,
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbarCard(
                                message = "Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить, Заполните пункты выше, чтобы продолжить"

//                                message = "Заполните пункты выше, чтобы продолжить"
                            )
                        }
                    },
                    horizontalPadding = 0.dp
                )
            }
        }
    }
}
