package cdr.corecompose.buttons.blueberry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.theming.getThemedColor
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme

/**
 * Превью для всех доступных кнопок (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun BlueberryPreviewLightTheme() {
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
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {})
                Blueberry(
                    text = "Подтвердить",
                    style = BlueberryStyle.Standard,
                    onClick = {},
                    isEnabled = false
                )
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Negative, onClick = {})
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {})
                Blueberry(
                    text = "Подтвердить",
                    style = BlueberryStyle.Transparent,
                    onClick = {},
                    isEnabled = false
                )
            }
        }
    }
}


/**
 * Превью для всех доступных кнопок (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun BlueberryPreviewDarkTheme() {
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
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {})
                Blueberry(
                    text = "Подтвердить",
                    style = BlueberryStyle.Standard,
                    onClick = {},
                    isEnabled = false
                )
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Negative, onClick = {})
                Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {})
                Blueberry(
                    text = "Подтвердить",
                    style = BlueberryStyle.Transparent,
                    onClick = {},
                    isEnabled = false
                )
            }
        }
    }
}