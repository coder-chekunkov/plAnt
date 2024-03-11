package cdr.corecompose.theming

import androidx.compose.ui.graphics.Color

/**
 * Значения цветов для темной темы
 *
 * @author Alexandr Chekunkov
 */
internal fun darkTheme(): Map<PlAntTokens, Color> = mapOf(
    PlAntTokens.Background0 to Graphite2,
    PlAntTokens.Background1 to Graphite1,
    PlAntTokens.ButtonBrand to ElectricBlue,
    PlAntTokens.ButtonDisabled to Gray,
    PlAntTokens.ButtonWarning to Orange,
    PlAntTokens.ButtonTransparent to Transparent,
    PlAntTokens.Brand to ElectricBlue,
    PlAntTokens.TextPrimary to White,
    PlAntTokens.TextSecondary to White1,
    PlAntTokens.TextButtonDisabled to Graphite0,
    PlAntTokens.TextButtonWhite to White,
    PlAntTokens.TextBrand to ElectricBlue,
    PlAntTokens.TextWarning to Orange,
    PlAntTokens.Transparent to Transparent
)
