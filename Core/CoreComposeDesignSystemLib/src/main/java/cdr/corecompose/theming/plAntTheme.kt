package cdr.corecompose.theming

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

/**
 * Темизированные токены для цветов
 *
 * @property tokens токены цветов
 *
 * @author Alexandr Chekunkov
 */
object PlAntTheme {
    internal val tokens: Map<PlAntTokens, Color>
        @Composable
        @ReadOnlyComposable
        get() = LocalTokens.current
}

/**
 * Основная тема, которая используется во всем приложении
 *
 * @param darkTheme true - темная тема, false - светлая тема
 * @param content основной контент
 *
 * @author Alexandr Chekunkov
 */
@Composable
fun PlAntTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalTokens provides getColorsThemeTokens(darkTheme)) {
       content()
    }
}

/**
 * Выбор соответсвующей темы цвета
 *
 * @author Alexandr Chekunkov
 */
@Composable
private fun getColorsThemeTokens(isDarkTheme: Boolean): Map<PlAntTokens, Color> =
    if (isDarkTheme) darkTheme() else lightTheme()