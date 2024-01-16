package cdr.corecompose.theming

import androidx.compose.ui.graphics.Color

/**
 * Значения цветов для светлой темы
 *
 * @author Alexandr Chekunkov
 */
internal fun lightTheme(): Map<PlAntTokens, Color> = mapOf(
    PlAntTokens.Background0 to White,
    PlAntTokens.Background1 to White,
    PlAntTokens.ButtonBrand to ElectricBlue,
    PlAntTokens.ButtonDisabled to Gray,
    PlAntTokens.ButtonWarning to Orange,
    PlAntTokens.ButtonTransparent to Transparent,
    PlAntTokens.TextPrimary to Black,
    PlAntTokens.TextSecondary to Black2,
    PlAntTokens.TextButtonDisabled to Black2,
    PlAntTokens.TextButtonWhite to White,
    PlAntTokens.TextBrand to ElectricBlue,
    PlAntTokens.TextWarning to Orange,
    PlAntTokens.Transparent to Transparent
)
