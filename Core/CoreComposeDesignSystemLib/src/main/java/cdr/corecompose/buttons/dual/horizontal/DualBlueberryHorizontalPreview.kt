package cdr.corecompose.buttons.dual.horizontal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для двойных горизонтальных кнопок (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun DualBlueberryHorizontalPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(PlAntTokens.Background1.getThemedColor()),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PlAntTokens.Background1.getThemedColor())
            ) {
                DualBlueberryHorizontal(
                    firstButtonText = "Удалить",
                    secondButtonText = "Отмена",
                    firstButtonClick = {},
                    secondButtonClick = {}
                )
            }
        }
    }
}

/**
 * Превью для двойных горизонтальных кнопок (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun DualBlueberryHorizontalPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .background(PlAntTokens.Background1.getThemedColor()),
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(PlAntTokens.Background1.getThemedColor())
            ) {
                DualBlueberryHorizontal(
                    firstButtonText = "Удалить",
                    secondButtonText = "Отмена",
                    firstButtonClick = {},
                    secondButtonClick = {}
                )
            }
        }
    }
}