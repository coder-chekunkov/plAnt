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
    PlAntTokens.Brand to ElectricBlue,
    PlAntTokens.IconSecondary to Black2,
    PlAntTokens.TextPrimary to Black,
    PlAntTokens.TextSecondary to Black2,
    PlAntTokens.TextButtonDisabled to Black2,
    PlAntTokens.TextButtonWhite to White,
    PlAntTokens.TextBrand to ElectricBlue,
    PlAntTokens.TextWarning to Orange,
    PlAntTokens.Transparent to Transparent,
    PlAntTokens.TextFieldBackground to Gray1,
    PlAntTokens.TextFieldText to Black,
    PlAntTokens.TextFieldUnfocusedText to Graphite0,
    PlAntTokens.TextFieldUnfocusedLabel to Graphite0,
    PlAntTokens.TextFieldWarningBackground to Orange1,
    PlAntTokens.TextFieldWarningText to Orange,
    PlAntTokens.TextFieldWarningUnfocusedText to Orange,
    PlAntTokens.TextFieldWarningUnfocusedLabel to Orange,
    PlAntTokens.Warning to Orange
)
