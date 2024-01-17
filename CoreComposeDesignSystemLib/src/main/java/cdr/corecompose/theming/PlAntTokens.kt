package cdr.corecompose.theming

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Токены для темы приложения
 *
 * @author Alexandr Chekunkov
 */
enum class PlAntTokens {
    Background0,
    Background1,
    ButtonBrand,
    ButtonDisabled,
    ButtonWarning,
    ButtonTransparent,
    Brand,
    TextPrimary,
    TextSecondary,
    TextBrand,
    TextWarning,
    TextButtonDisabled,
    TextButtonWhite,
    Transparent
}

/**
 * Получить цвет, соответствующую текущей теме
 */
@Composable
@ReadOnlyComposable
internal fun PlAntTokens.getThemedColor(): Color = PlAntTheme.tokens.getValue(this)

/**
 * Токены цветов
 */
internal val LocalTokens: ProvidableCompositionLocal<Map<PlAntTokens, Color>> =
    staticCompositionLocalOf { lightTheme() }
