package cdr.corecompose.buttons.dual.vertical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cdr.corecompose.buttons.blueberry.BlueberryStyle
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для двойных вертикальных кнопок (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun DualBlueberryVerticalPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background1.getThemedColor())
        ) {
            DualBlueberryVertical(
                firstButtonText = "Войти",
                secondButtonText = "Регистрация",
                firstButtonClick = {},
                secondButtonClick = {}
            )
        }
    }
}

/**
 * Превью для двойных вертикальных кнопок (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun DualBlueberryVerticalPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background1.getThemedColor())
        ) {
            DualBlueberryVertical(
                firstButtonText = "Отменить",
                secondButtonText = "Удалить аккаунт",
                firstButtonClick = {},
                secondButtonClick = {},
                secondButtonStyle = BlueberryStyle.Negative
            )
        }
    }
}