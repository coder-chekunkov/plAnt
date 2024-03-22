package cdr.corecompose.chip.chipcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cdr.corecompose.appbar.AppBar
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для [ChipCard] (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun ChipCardPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background0.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background0.getThemedColor(),
                    title = "ChipCard"
                )
            }
        ) { paddingValues ->
            Row(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Background0.getThemedColor())
            ) {
                ChipCard(
                    title = "Разработчик",
                    isSelected = false
                )
                ChipCard(
                    title = "Тестировщик",
                    isSelected = true
                )
                ChipCard(
                    title = "Менеджер",
                    isSelected = false,
                    style = ChipCardStyle.Warning
                )
            }
        }
    }
}

/**
 * Превью для [ChipCard] (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun ChipCardPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background0.getThemedColor())
                .padding(horizontal = 16.dp),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background0.getThemedColor(),
                    title = "ChipCard"
                )
            }
        ) { paddingValues ->
            Row(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Background0.getThemedColor())
            ) {
                ChipCard(
                    title = "Разработчик",
                    isSelected = false
                )
                ChipCard(
                    title = "Тестировщик",
                    isSelected = true
                )
                ChipCard(
                    title = "Менеджер",
                    isSelected = false,
                    style = ChipCardStyle.Warning
                )
            }
        }
    }
}