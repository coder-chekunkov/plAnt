package cdr.corecompose.theming

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Првеью тема, которая испльзуется только для демонстрации элементов Дизайн Системы
 *
 * @param modifier модифаер
 * @param darkTheme true - темная тема, false - светлая тема
 * @param content контнет на превью
 *
 * @author Alexandr Chekunkov
 */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun PreviewPlantTheme(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    PlAntTheme(darkTheme = darkTheme) {
        Scaffold(
            modifier = modifier,
            containerColor = PlAntTokens.Background1.getThemedColor()
        ) {
            content.invoke()
        }
    }
}
