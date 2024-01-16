package cdr.corecompose.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cdr.corecompose.theming.getThemedColor
import cdr.corecompose.theming.PlAntTheme
import cdr.corecompose.theming.PlAntTokens

/**
 * Превью для всех доступных кнопок (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
fun BlueberryPreviewLightTheme() {
    PlAntTheme(darkTheme = false) {
        Column(
            modifier = Modifier.background(PlAntTokens.Background0.getThemedColor())
        ) {
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {}, isEnabled = false)
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Negative, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {}, isEnabled =  false)
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
fun BlueberryPreviewDarkTheme() {
    PlAntTheme(darkTheme = true) {
        Column(
            modifier = Modifier.background(PlAntTokens.Background0.getThemedColor())
        ) {
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Standard, onClick = {}, isEnabled = false)
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Negative, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {})
            Blueberry(text = "Подтвердить", style = BlueberryStyle.Transparent, onClick = {}, isEnabled =  false)
        }
    }
}