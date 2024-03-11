package cdr.corecompose.progressbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cdr.corecompose.theming.PreviewPlantTheme

/**
 * Превью бесконечного круглого прогресс бара (светлая тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun ProgressBarPreviewLightTheme() {
    PreviewPlantTheme(darkTheme = false) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ProgressBarCircle(
                text = "Загрузка"
            )
        }
    }
}

/**
 * Превью бесконечного круглого прогресс бара (темная тема)
 *
 * @author Alexandr Chekunkov
 */
@Preview
@Composable
internal fun PreviewTheme() {
    PreviewPlantTheme(darkTheme = true) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            ProgressBarCircle(
                text = "Загрузка, Загрузка, Загрузка, Загрузка, Загрузка, Загрузка, Загрузка, Загрузка, Загрузка, Загрузка"
            )
        }
    }
}