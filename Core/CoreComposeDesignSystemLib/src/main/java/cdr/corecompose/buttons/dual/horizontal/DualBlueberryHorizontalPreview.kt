package cdr.corecompose.buttons.dual.horizontal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(cdr.corecompose.theming.PlAntTokens.Background1.getThemedColor())
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

/**
 * Превью для двойных горизонтальных кнопок (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun DualBlueberryHorizontalPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(cdr.corecompose.theming.PlAntTokens.Background1.getThemedColor())
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