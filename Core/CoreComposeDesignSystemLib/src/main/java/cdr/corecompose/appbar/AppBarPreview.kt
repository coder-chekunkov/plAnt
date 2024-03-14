package cdr.corecompose.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cdr.corecompose.theming.PlAntTokens
import cdr.corecompose.theming.PreviewPlantTheme
import cdr.corecompose.theming.getThemedColor

/**
 * Превью для AppBar (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun AppBarPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(PlAntTokens.Background0.getThemedColor()),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background0.getThemedColor(),
                    title = "Профиль",
                    navigationButton = AppBarNavigationButtons.Close
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Secondary.getThemedColor())
            ) {}
        }
    }
}

/**
 * Превью для AppBar (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun AppBarPreviewDarkTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppBar(
                    backgroundColor = PlAntTokens.Background1.getThemedColor(),
                    title = "Профиль"
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(PlAntTokens.Secondary.getThemedColor())
            ) {}
        }
    }
}
